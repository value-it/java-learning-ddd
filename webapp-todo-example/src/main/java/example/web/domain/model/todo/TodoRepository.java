package example.web.domain.model.todo;

import java.util.List;

public interface TodoRepository {

    List<Todo> findAll();

    void saveAsNew(Todo todo);
}
