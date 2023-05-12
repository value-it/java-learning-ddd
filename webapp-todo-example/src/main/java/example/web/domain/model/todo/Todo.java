package example.web.domain.model.todo;

public class Todo {
    private String title;
    private String description;
    private Boolean emergency;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean isEmergency() {
        return emergency;
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
}