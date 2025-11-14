package com.weverton.cadastrotarefas.services;

import com.weverton.cadastrotarefas.dto.TarefaRequestDTO;
import com.weverton.cadastrotarefas.entities.Tarefa;
import com.weverton.cadastrotarefas.exception.ResourceNotFoundException;
import com.weverton.cadastrotarefas.repositories.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<Tarefa> listarTodas() {
        return repository.findAll();
    }

    public Tarefa buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada."));
    }

    public Tarefa criarTarefa(TarefaRequestDTO dto) {
        Tarefa tarefa = new Tarefa();
        tarefa.setUser_name(dto.getUser_name());
        tarefa.setTitle(dto.getTitle());
        tarefa.setDescription(dto.getDescription());
        tarefa.setCreationDate(dto.getCreationDate());

        return repository.save(tarefa);
    }

    public Tarefa atualizar(Long id, TarefaRequestDTO dto) {
        Optional<Tarefa> opt = repository.findById(id);
        if (opt.isEmpty()) throw new ResourceNotFoundException("Tarefa não encontrada.");

        Tarefa t = opt.get();
        t.setTitle(dto.getTitle());
        t.setUser_name(dto.getUser_name());
        t.setDescription(dto.getDescription());
        t.setCompleted(dto.isCompleted());

        return repository.save(t);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Tarefa> completedTasks() {
        return repository.findByCompletedTrue();
    }
}
