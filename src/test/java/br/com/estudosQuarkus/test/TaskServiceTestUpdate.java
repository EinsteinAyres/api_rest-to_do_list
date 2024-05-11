package br.com.estudosQuarkus.test;

import br.com.estudosQuarkus.todo.model.Task;
import br.com.estudosQuarkus.todo.service.TaskService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static io.smallrye.common.constraint.Assert.assertTrue;

@QuarkusTest
public class TaskServiceTestUpdate {

    @Inject
    TaskService taskService;


    @Test
    @Transactional
    public void testUpdateTask() {
        Task task = new Task();
        task.setTitle("Tarefa Antiga");
        task.setDescription("Descrição da tarefa antiga");
        task.setDueDate(LocalDate.now().plusDays(7));

        taskService.createTask(task);

        task.setTitle("Tarefa Atualizada");
        task.setDescription("Descrição da tarefa atualizada");

        boolean updated = taskService.updateTask(task.getId(), task);

        assertTrue(updated); // Verifica se a tarefa foi atualizada com sucesso
    }

}
