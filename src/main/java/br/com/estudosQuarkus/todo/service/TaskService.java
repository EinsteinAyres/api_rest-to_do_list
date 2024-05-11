package br.com.estudosQuarkus.todo.service;

import br.com.estudosQuarkus.todo.model.Task;
import br.com.estudosQuarkus.todo.repository.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TaskService {

    @Inject
    TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.getTaskById(taskId);
    }

    public void createTask(Task task) {
        taskRepository.createTask(task);
    }

    public boolean updateTask(Long taskId, Task task) {
        Task existingTask = taskRepository.getTaskById(taskId);
        if (existingTask != null) {
            task.setId(taskId);
            taskRepository.updateTask(task);
            return true;
        }
        return false;
    }

    public boolean deleteTask(Long taskId) {
        Task existingTask = taskRepository.getTaskById(taskId);
        if (existingTask != null) {
            taskRepository.deleteTask(existingTask);
            return true;
        }
        return false;
    }
}