package br.com.estudosQuarkus.test;

import br.com.estudosQuarkus.todo.model.Task;
import br.com.estudosQuarkus.todo.service.TaskService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static io.smallrye.common.constraint.Assert.assertNotNull;

public class TaskServiceTestCreate {

    @Inject
    TaskService taskService;

    @Test
    @Transactional
    public void testCreateTask() {
        Task task = new Task();
        task.setTitle("Nova Tarefa");
        task.setDescription("Descrição da nova tarefa");
        task.setDueDate(LocalDate.now().plusDays(7));

        taskService.createTask(task);

        assertNotNull(task.getId()); // Verifica se o ID da tarefa foi atribuído
    }

}
