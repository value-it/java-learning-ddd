package example.web.infrastructure.datasource.todo.dao;

import example.web.domain.model.todo.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoListDao {
    private final List<TodoDao> todoDaoList;

    public TodoListDao(List<TodoDao> todoDaoList) {
        this.todoDaoList = todoDaoList;
    }

    public List<Todo> toDomainModel() {
        List<Todo> todoList = new ArrayList<>();
        for (TodoDao todoDao : todoDaoList) {
            todoList.add(todoDao.toDomainModel());
        }
        return todoList;
    }
}