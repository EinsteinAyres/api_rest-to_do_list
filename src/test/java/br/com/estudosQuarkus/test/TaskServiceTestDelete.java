package br.com.estudosQuarkus.test;


import br.com.estudosQuarkus.todo.model.Task;
import br.com.estudosQuarkus.todo.service.TaskService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.Test;

import java.time.LocalDate;

import static io.smallrye.common.constraint.Assert.assertTrue;

@QuarkusTest
public class TaskServiceTestDelete {

    @Inject
    TaskService taskService;

    @Test
    @Transactional
    public void testDeleteTask() {
        Task task = new Task();
        task.setTitle("Tarefa para Exclusão");
        task.setDescription("Descrição da tarefa para exclusão");
        task.setDueDate(LocalDate.now().plusDays(7));

        taskService.createTask(task);

        boolean deleted = taskService.deleteTask(task.getId());

        assertTrue(deleted); // Verifica se a tarefa foi excluída com sucesso
    }

}
