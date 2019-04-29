package com.example.easynotes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Todo;
import com.example.easynotes.repository.TodoRepository;

@RestController
@RequestMapping("/api")
public class TodoController {

	@Autowired
	TodoRepository todoRepository;

	@GetMapping("/todos")
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}

	@GetMapping("/todos/active")
	public List<Todo> getAllActiveTodos() {
		return todoRepository.findByStatus(false);
	}

	@PostMapping("/todos")
	public Todo createTodo(@Valid @RequestBody Todo todo) {
		return todoRepository.save(todo);
	}

	@GetMapping("/todos/complete/{id}")
	public Todo completeTodo(@PathVariable(value = "id") Long todoId) {
		Todo todo = todoRepository.findById(todoId)
				.orElseThrow(() -> new ResourceNotFoundException("Todo", "id", todoId));
		todo.setStatus(true);
		Todo updatedTodo = todoRepository.save(todo);
		return updatedTodo;
	}

	@DeleteMapping("/todos/{id}")
	public ResponseEntity<Todo> deleteTodo(@PathVariable(value = "id") Long todoId) {
		Todo todo = todoRepository.findById(todoId)
				.orElseThrow(() -> new ResourceNotFoundException("Todo", "id", todoId));
		todoRepository.delete(todo);
		return ResponseEntity.ok().build();
	}

}
