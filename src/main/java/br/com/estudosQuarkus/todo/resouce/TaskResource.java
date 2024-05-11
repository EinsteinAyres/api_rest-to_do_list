package br.com.estudosQuarkus.todo.resouce;

import br.com.estudosQuarkus.todo.model.Task;
import br.com.estudosQuarkus.todo.service.TaskService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class TaskResource {

    @Inject
    TaskService taskService;

    @GET
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GET
    @Path("/{taskId}")
    public Response getTaskById(@PathParam("taskId") Long taskId) {
        Task task = taskService.getTaskById(taskId);
        if (task != null) {
            return Response.ok(task).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createTask(Task task) {
        taskService.createTask(task);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{taskId}")
    public Response updateTask(@PathParam("taskId") Long taskId, Task task) {
        boolean updated = taskService.updateTask(taskId, task);
        if (updated) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{taskId}")
    public Response deleteTask(@PathParam("taskId") Long taskId) {
        boolean deleted = taskService.deleteTask(taskId);
        if (deleted) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
