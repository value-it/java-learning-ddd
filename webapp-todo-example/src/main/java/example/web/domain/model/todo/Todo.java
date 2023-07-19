package example.web.domain.model.todo;

public class Todo {
    private Long id;
    private Title title;
    private String description;
    private Boolean emergency = false;
    private Integer priority = 0;

    public Todo() {
    }

    public boolean isValid() {
        // Titleが正しいことを検証する
        if (title.getValue().contains("\"")) {
            return false;
        }

        return true;
    }

    public Long getId() {
        return id;
    }

    public Title getTitle() {
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
        this.title = new Title(title);
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
