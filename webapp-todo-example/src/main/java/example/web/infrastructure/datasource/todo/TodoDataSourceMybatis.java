package example.web.infrastructure.datasource.todo;

import example.web.domain.model.todo.Todo;
import example.web.domain.model.todo.TodoList;
import example.web.domain.model.todo.TodoRepository;
import example.web.infrastructure.datasource.todo.dto.TodoDto;
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
        TodoDto todoDto = mapper.findByTitle(title);
        return todoDto.toDomainModel();
    }

    @Override
    public void saveAsNew(Todo todo) {
        todo.setId(mapper.nextId());
        mapper.insert(todo);
    }
}
