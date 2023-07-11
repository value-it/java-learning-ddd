package example.web.domain.model.todo;

import java.util.List;

public class TodoList {
    private List<Todo> list;

    public TodoList(List<Todo> list) {
        this.list = list;
    }
    public int totalCount() {
        return list.size();
    }

    public int emergencyCount() {
        int emergencyCount = 0;
        for (Todo todo : list) {
            if (todo.getEmergency()) {
                emergencyCount++;
            }
        }
        return emergencyCount;
    }

    public List<Todo> getList() {
        return list;
    }


}
