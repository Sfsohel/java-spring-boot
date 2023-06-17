package com.topic01.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.topic01.todo.entity.Todo;
import com.topic01.todo.service.TodoService;

@RestController
public class TodoController {

  @Autowired
  private TodoService todoService;

  @PostMapping("/todos")
  public Todo saveTodo(@RequestBody Todo todo) {
    return todoService.saveTodo(todo);
  }

  @GetMapping("/todos")
  public List<Todo> getAllTodos() {
    return todoService.fetchAllTodos();
  }

  @GetMapping("/todos/{id}")
  public Todo getTodoById(@PathVariable("id") Long id) {
      return todoService.getTodoById(id);
  }

  @PutMapping("/todos/{id}")
  public Todo updateTodoById(@PathVariable("id") Long id, @RequestBody Todo todo) {
    return todoService.updateTodoById(id, todo);
  }

  @DeleteMapping("/todos/{id}")
  public Todo deleteTodoById(@PathVariable("id") Long id) {
    return todoService.deleteTodoById(id);
  }
}
