package com.example.todolist;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service  // Tells Spring this class contains business logic
    public class TaskService{
        private final TaskRepository taskRepositary;

        public class TaskService(TaskRepositary taskRepositary) {
        this.taskRepositary = taskRepositary;
        }
    
    
    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepositary.findAll();
    }

    // Add a new task
    public Task addTask(Task task) {
        return taskRepositary.save(task);
       
    }

    // Update a task by id
    public Task updateTask(int id, Task updatedTask) {
        return taskRepositary.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setCompleted(updatedTask.isCompleted());
            return taskRepositary.save(task);
        }).orElse(null);
    }

            }
        
        return null; // If not found
    

    // Delete a task by id
    public String deleteTask(int id) {
        if(taskRepository.existsById(id)){
           taskRepositary.deleteById(id):
                return "Task with id " + id + " deleted successfully!";
            }
        }
        return "Task not found!";
    }
}
