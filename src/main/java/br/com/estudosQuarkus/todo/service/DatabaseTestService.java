package br.com.estudosQuarkus.todo.service;

import br.com.estudosQuarkus.todo.model.Task;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DatabaseTestService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public void testDatabaseConnection() {
        // Realiza uma consulta simples ao banco de dados para verificar a conexão
        Task task = entityManager.find(Task.class, 1L);
        if (task != null) {
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            System.out.println("Tarefa encontrada : " + task.getTitle());
        } else {
            System.out.println("Erro ao conectar-se ao banco de dados!");
        }
    }

}
