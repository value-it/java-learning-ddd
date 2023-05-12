package example.web.infrastructure.datasource.todo;

import example.web.domain.model.todo.Todo;
import example.web.domain.model.todo.TodoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoDataSourceMybatis implements TodoRepository {

    private TodoMapper mapper;

    public TodoDataSourceMybatis(TodoMapper todoMapper) {
        this.mapper = todoMapper;
    }

    @Override
    public List<Todo> findAll() {
        return mapper.findAll();
    }

    @Override
    public void saveAsNew(Todo todo) {
        mapper.insert(todo);
    }
}
