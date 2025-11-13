package com.weverton.cadastrotarefas.services;

import com.weverton.cadastrotarefas.entities.Tarefa;
import com.weverton.cadastrotarefas.repositories.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Tarefa criarTarefa(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public Tarefa atualizar(Long id, Tarefa novaTarefa) {
        Tarefa tarefa = buscarPorId(id);
        if (tarefa != null) {
            tarefa.setTitle(novaTarefa.getTitle());
            tarefa.setDescription(novaTarefa.getDescription());
            tarefa.setCompleted(novaTarefa.getCompleted());
            return repository.save(tarefa);
        }
        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Tarefa> completedTasks() {
        return repository.findByCompletedTrue();
    }
}
