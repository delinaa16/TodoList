package com.example.todolist;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(int id){
        super("Task with id " + id + " not found");
    }
}
