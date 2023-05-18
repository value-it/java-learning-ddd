package example.web.infrastructure.datasource.todo;

import example.web.domain.model.todo.Todo;
import example.web.domain.model.todo.TodoRepository;
import example.web.infrastructure.datasource.todo.dao.TodoListDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Primary
public class TodoDataSourceMybatis implements TodoRepository {

    private TodoMapper mapper;

    public TodoDataSourceMybatis(TodoMapper todoMapper) {
        this.mapper = todoMapper;
    }

    @Override
    public List<Todo> findAll() {
        TodoListDao todoDaoList = new TodoListDao(mapper.findAll());
        return todoDaoList.toDomainModel();
    }

    @Override
    public Todo findByTitle(String title) {
        return mapper.findByTitle(title).toDomainModel();
    }

    @Override
    public void saveAsNew(Todo todo) {
        todo.setId(mapper.nextId());
        mapper.insert(todo);
    }
}
