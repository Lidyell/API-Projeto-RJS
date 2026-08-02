package com.example.todolist.Manipulation.Archive.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.NotBlank;

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
    private String descrition;


}
