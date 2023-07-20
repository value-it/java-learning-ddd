package example.web.infrastructure.datasource.todo.dto;

import example.web.domain.model.todo.Todo;

public class TodoDto {
    private Long id;
    private String title;
    private String description;
    private Boolean emergency;
    private Integer priority;

    public TodoDto(Long id, String title, String description, Boolean emergency, Integer priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.emergency = emergency;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getEmergency() {
        return emergency;
    }

    public Integer getPriority() {
        return priority;
    }

    public Todo toDomainModel() {
        Todo todo = new Todo();
        todo.setId(id);
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setEmergency(emergency);
        todo.setPriority(priority);
        return todo;
    }
}
