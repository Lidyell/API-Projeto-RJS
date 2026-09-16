package com.example.todolist.Manipulation.Archive.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "Tasks")
public class Archive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Titulo precisa estar preenchido")
    private String title;

    @NotBlank(message = "A descrição precisa estar preenchida")
    private String description;
}