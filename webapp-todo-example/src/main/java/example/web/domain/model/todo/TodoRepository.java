package example.web.domain.model.todo;

public interface TodoRepository {

    TodoList findAll();

    Todo findByTitle(String title);

    void saveAsNew(Todo todo);
}
