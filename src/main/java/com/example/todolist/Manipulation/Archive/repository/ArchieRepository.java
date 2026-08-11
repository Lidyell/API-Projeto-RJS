package com.example.todolist.Manipulation.Archive.repository;

import com.example.todolist.Manipulation.Archive.model.Archive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArchieRepository extends JpaRepository<Archive, Long> {
    Optional<Archive> findByTitleAndDescription(String title, String description);
}
