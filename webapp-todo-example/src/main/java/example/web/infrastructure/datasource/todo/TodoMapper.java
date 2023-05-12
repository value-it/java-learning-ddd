package example.web.infrastructure.datasource.todo;

import example.web.domain.model.todo.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    List<Todo> findAll();

    Long nextId();

    void insert(Todo todo);
}
