package example.web.domain.model.todo;

import javax.validation.Valid;

public class Todo {
    private Long id;
    @Valid
    private String title;
    private String description;
    private Boolean emergency = false;
    private Integer priority = 0;

    public Todo() {
    }

    public Todo(Long id, String title, String description, Boolean emergency, Integer priority) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmergency(Boolean emergency) {
        this.emergency = emergency;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}