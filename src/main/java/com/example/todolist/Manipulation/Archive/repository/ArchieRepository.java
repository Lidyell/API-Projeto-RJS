package com.example.todolist.Manipulation.Archive.repository;

import com.example.todolist.Manipulation.Archive.model.Archive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArchieRepository extends JpaRepository<Archive, Long> {
    @Override
    Optional<Archive> findById(Long id);
    Optional<Archive> findByTitleandDescrition(String title, String descrition);
}
