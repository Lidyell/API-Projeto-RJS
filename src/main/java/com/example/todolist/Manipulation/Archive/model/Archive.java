package com.example.todolist.Manipulation.Archive.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Table(name = "Tasks")
@Entity
public class Archive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Titulo precisa estar preenchido")
    private String title;

    @NotBlank(message = "A descrição precisa estar preenchida")
    private String description;
}