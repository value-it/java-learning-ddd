package example.web.domain.model.todo;

import java.util.List;

public interface TodoRepository {

    List<Todo> findAll();

    Long nextId();

    void saveAsNew(Todo todo);
}
