package example.web.presentation.controller.todo.register;

import example.web.domain.model.todo.Todo;

public class TodoRegisterForm {

    private String title;
    private String description;
    private boolean emergency;

    public TodoRegisterForm() {
        this.title = "";
        this.description = "";
        this.emergency = false;
    }

    public Todo toDomainEntity() {
        Todo todo = new Todo();
        todo.setTitle(this.title);
        todo.setDescription(this.description);
        todo.setEmergency(this.emergency);
        return todo;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean getEmergency() {
        return emergency;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }
}
