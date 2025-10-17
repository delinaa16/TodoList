package com.example.todolist;
import org.springframework.stereotype.Indexed;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // this calass is an entity and is mapped to a database table

public class Task {

    @Id  
    @GeneratedValue(strategy = Generation.IDENTITY)

    private int id;
    private String title;
    private boolean completed;

    // Constructor
    public Task(int id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {  // FIXED
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
