package br.com.estudosQuarkus.todo;

import br.com.estudosQuarkus.todo.service.DatabaseTestService;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@QuarkusMain
@ApplicationScoped
public class Main  implements QuarkusApplication {

    @Inject
    DatabaseTestService databaseTestService;

    @Override
    public int run(String... args) throws Exception {
        // Chama o serviço para testar a conexão com o banco de dados
        databaseTestService.testDatabaseConnection();
        return 0;
    }

    public static void main(String... args) {
        Quarkus.run(Main.class, args);
    }

}
