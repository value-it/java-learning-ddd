package example.web.domain.model.todo;

public class Todo {
    private Long id;
    private String title;
    private String description;
    private Boolean emergency;

    private int priority;

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

    public int getPriority() {
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

    public void setPriority(int priority) {
        this.priority = priority;
    }
}