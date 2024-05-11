package br.com.estudosQuarkus.todo.repository;

import br.com.estudosQuarkus.todo.model.Task;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TaskRepository {

    @Inject
    EntityManager entityManager;

    public List<Task> getAllTasks() {
        return entityManager.createQuery("SELECT t FROM Task t", Task.class).getResultList();
    }

    public Task getTaskById(Long taskId) {
        return entityManager.find(Task.class, taskId);
    }

    @Transactional
    public void createTask(Task task) {
        entityManager.persist(task);
    }

    @Transactional
    public void updateTask(Task task) {
        entityManager.merge(task);
    }

    @Transactional
    public void deleteTask(Task task) {
        entityManager.remove(
                entityManager.contains(task) ? task : entityManager.merge(task));
    }
}
