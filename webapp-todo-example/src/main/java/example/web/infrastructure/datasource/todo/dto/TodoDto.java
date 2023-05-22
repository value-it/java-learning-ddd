package example.web.infrastructure.datasource.todo.dto;

import example.web.domain.model.todo.Todo;

public class TodoDto {
    private Long id;
    private String title;
    private String description;
    private Boolean emergency;
    private Integer priority;

    public Todo toDomainModel() {
        var todo = new Todo();
        todo.setId(id);
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setEmergency(emergency);
        todo.setPriority(priority);
        return todo;
    }
}