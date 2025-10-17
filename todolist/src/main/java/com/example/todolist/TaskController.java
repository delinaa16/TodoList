package com.example.todolist;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService; // Declare it

    // Constructor — Spring will automatically inject TaskService here
    public TaskController(TaskService taskService) {
        this.taskService = taskService; // assign it to the variable above
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks(); // use it here
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        return taskService.updateTask(id, updatedTask);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        return taskService.deleteTask(id);
    }

    @GetMapping("/filter")
    public List<Task> getTasksByCompleted(@RequestParam boolean completed) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : taskService.getAllTasks()) {
            if (task.isCompleted() == completed) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }
}
