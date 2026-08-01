package com.example.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.todolist.Creation.Archive.ControllerCreation;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);

		ControllerCreation ctrl = new ControllerCreation();
		int no = 10;
		int result = ctrl.Soma(no);
		System.out.println(result);
	}

}
