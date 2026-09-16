package com.example.todolist.Manipulation.Archive.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.Manipulation.Archive.Model.Archive;

import java.util.Optional;

public interface ArchieRepository extends JpaRepository<Archive, Long> {

    Optional<Archive> findByTitleAndDescription(String title, String description);
}
