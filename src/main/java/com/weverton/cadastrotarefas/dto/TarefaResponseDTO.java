package com.weverton.cadastrotarefas.dto;

import com.weverton.cadastrotarefas.entities.Tarefa;

public class TarefaResponseDTO {

    private Long id;
    private String user_name;
    private String title;
    private String description;
    private boolean completed;

    public TarefaResponseDTO(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.user_name = tarefa.getUser_name();
        this.title = tarefa.getTitle();
        this.description = tarefa.getDescription();
        this.completed = tarefa.isCompleted();
    }

    public Long getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }
}
