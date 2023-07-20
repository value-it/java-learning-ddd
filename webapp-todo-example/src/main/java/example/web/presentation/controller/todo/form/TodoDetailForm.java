package example.web.presentation.controller.todo.form;

import example.web.domain.model.todo.Todo;

public class TodoDetailForm {

    private Long id;
    private String title;
    private String description;
    private Boolean emergency;
    private Integer priority;

    public TodoDetailForm(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitleHoge().getValue();
        this.description = todo.getDescription().getValue();
        this.emergency = todo.getEmergency();
        this.priority = todo.getPriority();
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
}
