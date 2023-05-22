package example.web.infrastructure.datasource.todo;

import example.web.domain.model.todo.Todo;
import example.web.infrastructure.datasource.todo.dto.TodoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    List<TodoDto> findAll();

    TodoDto findByTitle(String title);

    Long nextId();

    void insert(Todo todo);
}
