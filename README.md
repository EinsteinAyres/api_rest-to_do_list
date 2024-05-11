# api_rest-to_do_list
Estudo em Quarkus - Projeto: uma To Do List


*******************************************************************
Passo a passo que a própria instalação do Quarkus indicou:
----------------------------------------------------------

api_rest-to_do_list
Este projeto usa Quarkus, o Supersonic Subatomic Java Framework.

Se você quiser saber mais sobre o Quarkus, visite seu site: https://quarkus.io/.

Executando o aplicativo no modo dev
Você pode executar seu aplicativo no modo de desenvolvimento que permite codificação ao vivo usando:

./mvnw compila quarkus:dev
NOTA: O Quarkus agora vem com uma Dev UI, que está disponível no modo dev apenas em http://localhost:8080/q/dev/.

Empacotando e executando o aplicativo
O aplicativo pode ser empacotado usando:

pacote ./mvnw
Ele produz o arquivo quarkus-run.jar no diretório target/quarkus-app/. Esteja ciente de que não é um über-jar, pois as dependências são copiadas para o diretório target/quarkus-app/lib/.

O aplicativo agora pode ser executado usando java -jar target/quarkus-app/quarkus-run.jar.

Se você deseja construir um über-jar, execute o seguinte comando:

./mvnw pacote -Dquarkus.package.jar.type=uber-jar
O aplicativo, empacotado como um über-jar, agora pode ser executado usando java -jar target/*-runner.jar.

Criando um executável nativo
Você pode criar um executável nativo usando:

./mvnw pacote -Dnative
Ou, se você não tiver o GraalVM instalado, você pode executar a compilação executável nativa em um contêiner usando:

./mvnw pacote -Dnative -Dquarkus.native.container-build=true
Você pode então executar seu executável nativo com: ./target/api_rest-to_do_list-1.0.0-SNAPSHOT-runner

Se você quiser saber mais sobre como construir executáveis nativos, consulte https://quarkus.io/guides/maven-tooling.

Provided Code
REST

Inicie facilmente seus serviços Web REST

*****************************************************************************************************************
*****************************************************************************************************************
Passo a passo do edsenvolvimento
--------------------------------


# API-REST-de-To-Do-List
Projeto de estudo de Quarkus


Passo 1: Instalação do Quarkus

1.1. Baixe e instale o Java Development Kit (JDK) versão 11 ou superior, se ainda não tiver instalado. Você pode baixar o JDK no site oficial da Oracle ou optar por distribuições como OpenJDK.

1.2. Acesse o site oficial do Quarkus em https://quarkus.io/ e clique no botão "Get Started". Aqui você encontrará duas maneiras principais de começar: usando o Quarkus CLI ou usando Maven.

Usando Quarkus CLI: O Quarkus CLI é uma ferramenta de linha de comando que facilita a criação e execução de projetos Quarkus. Para instalá-lo, você pode seguir as instruções específicas do seu sistema operacional fornecidas no site do Quarkus.

Usando Maven: Se preferir trabalhar com Maven, você pode adicionar o plugin do Quarkus ao seu arquivo pom.xml. Basta seguir as instruções fornecidas na seção "Using Maven" no site do Quarkus.

1.3. Depois de instalar o Quarkus CLI ou configurar o plugin Maven, verifique se a instalação foi bem-sucedida executando mvn quarkus:list-extensions no terminal. Isso deve listar as extensões disponíveis para o Quarkus, confirmando que o Quarkus está configurado corretamente em seu ambiente.

***********************************************************************************

Passo 2: Configuração do Projeto no IntelliJ

2.1. Abra o IntelliJ IDEA e selecione "File" > "New" > "Project from Existing Sources".

2.2. Navegue até a pasta onde você deseja criar o projeto e selecione o arquivo pom.xml do projeto Quarkus que você baixou ou criou anteriormente.

2.3. O IntelliJ irá detectar automaticamente que é um projeto Maven e abrirá o assistente de importação do Maven.

2.4. No assistente de importação do Maven, certifique-se de selecionar a opção para importar como um projeto Maven e clique em "Next".

2.5. Na próxima tela, você pode ajustar as configurações de importação conforme necessário. Normalmente, as configurações padrão são suficientes, então você pode clicar em "Next" novamente.

2.6. O IntelliJ agora começará a importar as dependências do Maven e configurar o projeto. Este processo pode levar alguns minutos, dependendo da complexidade do seu projeto e da velocidade da sua conexão com a internet.

2.7. Uma vez concluída a importação, o IntelliJ abrirá o projeto Quarkus em sua janela principal e você estará pronto para começar a desenvolver.

2.8. Certifique-se de que o IntelliJ esteja configurado para usar o JDK que você instalou no Passo 1. Você pode verificar e ajustar essa configuração em "File" > "Project Structure" > "Project" e selecionar o JDK apropriado na lista suspensa "Project SDK".

***********************************************************************************

Passo 3: Desenvolvimento da API REST

3.1. Abra o arquivo src/main/java no IntelliJ e crie as classes necessárias para a API REST de To-Do List, como controladores, modelos e serviços. Você pode criar um novo pacote para organizar suas classes, por exemplo, com.seuapp.todo.

3.2. Utilize as anotações do Quarkus para configurar os endpoints RESTful. Por exemplo, para criar um controlador para manipular as operações CRUD da lista de tarefas, você pode criar uma classe TodoResource e anotá-la com @Path("/todos").


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {
    // Métodos para manipular as operações CRUD da lista de tarefas
}


3.3. Implemente a lógica de negócios dentro do controlador ou, de preferência, em serviços separados. Por exemplo, você pode criar uma classe TodoService para lidar com a lógica de manipulação de tarefas.


import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TodoService {
    // Implemente métodos para criar, ler, atualizar e excluir tarefas
}


3.4. Injete o serviço necessário dentro do seu controlador usando a anotação @Inject.


import javax.inject.Inject;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {
    
    @Inject
    TodoService todoService;

    // Métodos para manipular as operações CRUD da lista de tarefas
}


3.5. Implemente métodos dentro do controlador para lidar com as operações CRUD da lista de tarefas, utilizando métodos HTTP apropriados (GET, POST, PUT, DELETE).

3.6. Teste os endpoints da sua API localmente. Você pode fazer isso iniciando o servidor Quarkus no modo de desenvolvimento e utilizando uma ferramenta como o Postman para enviar solicitações HTTP aos endpoints que você implementou.

***********************************************************************************

Passo 4: Execução e Teste do Projeto Localmente

4.1. Abra o terminal no IntelliJ ou em um terminal separado e navegue até o diretório raiz do seu projeto Quarkus.

4.2. Execute o comando mvn compile quarkus:dev no terminal para iniciar o servidor Quarkus no modo de desenvolvimento.

O modo de desenvolvimento do Quarkus é altamente produtivo, pois oferece hot-reload automático, o que significa que o servidor será reiniciado automaticamente sempre que você fizer alterações no código.
4.3. Após o servidor iniciar, ele estará pronto para aceitar solicitações HTTP.

4.4. Abra uma ferramenta como o Postman ou utilize o navegador para testar os endpoints da sua API. Por exemplo, se você tiver um endpoint GET para obter todas as tarefas, você pode acessá-lo em http://localhost:8080/todos.

4.5. Envie solicitações HTTP para os diferentes endpoints da sua API para garantir que eles estejam funcionando conforme o esperado. Teste todas as operações CRUD (CREATE, READ, UPDATE, DELETE) para garantir que sua API esteja funcionando corretamente.

4.6. Enquanto estiver no modo de desenvolvimento, o Quarkus também exibirá mensagens de log úteis no terminal para ajudar na depuração de problemas e no rastreamento do funcionamento da aplicação.

4.7. Mantenha o servidor Quarkus em execução no modo de desenvolvimento enquanto você estiver desenvolvendo e testando sua aplicação. Qualquer alteração que você fizer no código será automaticamente refletida no servidor sem a necessidade de reiniciar manualmente.

***********************************************************************************

Passo 5: Empacotamento e Implantação do Projeto

5.1. Quando estiver satisfeito com o desenvolvimento e os testes locais da sua aplicação, pare o servidor Quarkus pressionando Ctrl + C no terminal onde o servidor está sendo executado.

5.2. Para empacotar o projeto, execute o comando mvn package. Isso criará um arquivo JAR executável na pasta target do seu projeto.

O arquivo JAR gerado contém todas as dependências necessárias para sua aplicação Quarkus, tornando-a portável e independente de ambiente.
5.3. Antes de implantar o arquivo JAR em um ambiente de produção, você pode querer testá-lo localmente para garantir que tudo esteja funcionando conforme o esperado. Você pode fazer isso executando o JAR diretamente com o comando java -jar target/nome-do-seu-arquivo.jar.

5.4. Depois de verificar que o JAR está funcionando corretamente, você pode implantá-lo em um ambiente de produção. Isso pode ser feito em várias plataformas, como servidores de aplicativos tradicionais, contêineres Docker ou plataformas de nuvem como AWS, Google Cloud ou Azure.

5.5. Para implantar em um ambiente de contêiner Docker, você precisa criar um Dockerfile no diretório raiz do seu projeto. O Dockerfile pode ser simples e conter instruções básicas, como copiar o arquivo JAR para dentro da imagem Docker e definir o comando de inicialização.


FROM adoptopenjdk/openjdk11:alpine
WORKDIR /app
COPY target/nome-do-seu-arquivo.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]


5.6. Depois de criar o Dockerfile, você pode construir a imagem Docker com o comando docker build -t nome-da-sua-imagem . e executá-la com o comando docker run -p 8080:8080 nome-da-sua-imagem.

5.7. Para implantar em uma plataforma de nuvem, consulte a documentação da plataforma específica para obter instruções detalhadas sobre como implantar aplicativos Java. Muitas plataformas oferecem integração direta com Maven ou Docker, facilitando o processo de implantação.

***********************************************************************************

Passo 6: Subir o Projeto em um Repositório (opcional)

6.1. Se desejar compartilhar seu código com outras pessoas ou manter um histórico de versões do seu projeto, é uma boa prática subir o projeto para um repositório de controle de versão, como GitHub, GitLab ou Bitbucket.

6.2. Primeiro, certifique-se de ter instalado e configurado um cliente Git em seu sistema. Você pode verificar isso digitando git --version no terminal. Se o Git não estiver instalado, baixe e instale-o em https://git-scm.com/.

6.3. No diretório raiz do seu projeto, inicialize um repositório Git com o comando git init. Isso criará um repositório local para o seu projeto.

6.4. Crie um arquivo .gitignore no diretório raiz do seu projeto para especificar quais arquivos e diretórios devem ser ignorados pelo Git. Isso geralmente inclui arquivos binários compilados, arquivos de log e diretórios temporários. Você pode encontrar exemplos de arquivos .gitignore adequados para projetos Java no site https://github.com/github/gitignore.

6.5. Adicione todos os arquivos do seu projeto ao controle de versão Git com o comando git add .. Isso prepara todos os arquivos e diretórios do seu projeto para serem confirmados.

6.6. Faça o primeiro commit do seu projeto com o comando git commit -m "Primeiro commit". Isso confirma todas as alterações no seu repositório Git local.

6.7. Agora você precisa configurar um repositório remoto onde seu projeto será hospedado. Isso geralmente é feito em uma plataforma de hospedagem de código como GitHub, GitLab ou Bitbucket.

6.8. Crie um novo repositório vazio na plataforma de hospedagem de sua escolha. Siga as instruções na plataforma para criar um novo repositório.

6.9. Depois de criar o repositório remoto, você será fornecido com uma URL de clone. Use essa URL para adicionar o repositório remoto ao seu repositório Git local com o comando git remote add origin URL_DO_REPOSITORIO.

6.10. Finalmente, faça o push do seu projeto para o repositório remoto com o comando git push -u origin master. Isso enviará todos os commits do seu repositório Git local para o repositório remoto.

6.11. Se tudo correr bem, seu projeto estará agora hospedado no repositório remoto e estará disponível para ser compartilhado e colaborado com outras pessoas.




