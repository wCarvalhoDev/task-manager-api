package com.weverton.cadastrotarefas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class TarefaRequestDTO {

    @NotBlank(message = "Usuário obrigatório")
    private String user_name;

    @NotBlank(message = "O título é obrigatório")
    private String title;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime creationDate;

    @Size(max = 255, message = "A descrição deve ter no máximo 225 caracteres.")
    private String description;

    private boolean completed;

    public TarefaRequestDTO(String user_name, String title, LocalDateTime creationDate, String description, boolean completed) {
        this.user_name = user_name;
        this.title = title;
        this.creationDate = creationDate;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
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
