package com.example.todolist;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id)); // ✅ throws exception
    }

    public Task updateTask(int id, Task updatedTask) {
        return taskRepository.findById(id)
            .map(task -> {
                task.setTitle(updatedTask.getTitle());
                task.setCompleted(updatedTask.isCompleted());
                return taskRepository.save(task);
            }).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public String deleteTask(int id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
        return "Task with ID " + id + " has been deleted.";
    }
}
