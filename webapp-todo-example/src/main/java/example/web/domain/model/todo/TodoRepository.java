package example.web.domain.model.todo;

import java.util.List;

public interface TodoRepository {

    TodoList findAll();

    Todo findByTitle(String title);

    void saveAsNew(Todo todo);
}
