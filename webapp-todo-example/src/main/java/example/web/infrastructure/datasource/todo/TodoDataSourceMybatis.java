package example.web.infrastructure.datasource.todo;

import example.web.domain.model.todo.Todo;
import example.web.domain.model.todo.TodoList;
import example.web.domain.model.todo.TodoRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class TodoDataSourceMybatis implements TodoRepository {

    private final TodoMapper mapper;

    public TodoDataSourceMybatis(TodoMapper todoMapper) {
        this.mapper = todoMapper;
    }

    @Override
    public TodoList findAll() {
        return new TodoList(mapper.findAll());
    }

    @Override
    public Todo findByTitle(String title) {
        return mapper.findByTitle(title);
    }

    @Override
    public void saveAsNew(Todo todo) {
        todo.setId(mapper.nextId());
        mapper.insert(todo);
    }
}
