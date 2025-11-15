package com.weverton.cadastrotarefas.controllers;

import com.weverton.cadastrotarefas.dto.TarefaRequestDTO;
import com.weverton.cadastrotarefas.dto.TarefaResponseDTO;
import com.weverton.cadastrotarefas.entities.Tarefa;
import com.weverton.cadastrotarefas.services.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listarTodas() {
        List<Tarefa> tarefas = service.listarTodas();

        List<TarefaResponseDTO> response = tarefas.stream()
                .map(TarefaResponseDTO::new)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> buscarPorId(@PathVariable Long id) {
        Tarefa tarefa = service.buscarPorId(id);
        return ResponseEntity.ok(new TarefaResponseDTO(tarefa));
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criarTarefa(@Valid @RequestBody TarefaRequestDTO dto) {
        Tarefa tarefa = service.criarTarefa(dto);

        TarefaResponseDTO response = new TarefaResponseDTO(tarefa);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tarefa.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody TarefaRequestDTO requestDTO) {
        Tarefa tarefa = service.atualizar(id, requestDTO);
        TarefaResponseDTO response = new TarefaResponseDTO(tarefa);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Tarefa>>completedTask(){
        List<Tarefa> tarefas = service.completedTasks();
        return ResponseEntity.ok(tarefas);
    }
}
