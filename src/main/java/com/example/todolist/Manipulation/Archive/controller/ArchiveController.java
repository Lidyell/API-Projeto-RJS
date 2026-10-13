package com.example.todolist.Manipulation.Archive.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/p1/archives")
public class ArchiveController {

    @GetMapping
    public String Mostrar(){
        return "Aba Principal";
    }

}
