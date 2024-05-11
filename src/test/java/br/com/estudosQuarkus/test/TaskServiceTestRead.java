package br.com.estudosQuarkus.test;

import br.com.estudosQuarkus.todo.model.Task;
import br.com.estudosQuarkus.todo.service.TaskService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static io.smallrye.common.constraint.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


@QuarkusTest
public class TaskServiceTestRead {

    @Inject
    TaskService taskService;

    @Test
    @Transactional

    public void testGetTaskById() {
        Task task = new Task();
        task.setTitle("Nova Tarefa");
        task.setDescription("Descrição da nova tarefa");
        task.setDueDate(LocalDate.now().plusDays(7));

        taskService.createTask(task);

        Task retrievedTask = taskService.getTaskById(task.getId());

        assertNotNull(retrievedTask); // Verifica se a tarefa foi recuperada com sucesso
        assertEquals(task.getTitle(), retrievedTask.getTitle()); // Verifica se os detalhes da tarefa são os mesmos
    }

}
