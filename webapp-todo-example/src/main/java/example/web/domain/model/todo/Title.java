package example.web.domain.model.todo;

public class Title {
    private String value;

    public Title(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getSummary() {
        if (value.length() > 30) {
            return value.substring(0, 30) + "...";
        }
        return value;
    }
}
