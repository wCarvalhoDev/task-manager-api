package com.weverton.cadastrotarefas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TarefaRequestDTO {

    @NotBlank(message = "Usuário obrigatório")
    private String user_name;

    @NotBlank(message = "O título é obrigatório")
    private String title;

    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres.")
    private String description;

    private boolean completed;

    public TarefaRequestDTO() {
    }

    public TarefaRequestDTO(String user_name, String title, String description, boolean completed) {
        this.user_name = user_name;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
