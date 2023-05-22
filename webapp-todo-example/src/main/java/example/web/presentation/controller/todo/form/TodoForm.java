package example.web.presentation.controller.todo.form;

import example.web.domain.model.todo.Todo;

public class TodoForm {
    public String title;
    public String description;
    public Boolean emergency;
    public Integer priority;

    public TodoForm() {
        this.title = "";
        this.description = "";
        this.emergency = false;
        this.priority = 0;
    }

    public Todo toDomainModel() {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setEmergency(emergency);
        todo.setPriority(priority);
        return todo;
    }

    public boolean isValid() {
        return this.toDomainModel().isValid();
    }
}