package example.web.infrastructure.datasource.todo.dto;

import example.web.domain.model.todo.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoListDto {
    private final List<TodoDto> todoDtoList;

    public TodoListDto(List<TodoDto> todoDtoList) {
        this.todoDtoList = todoDtoList;
    }

    public List<Todo> toDomainModel() {
        List<Todo> todoList = new ArrayList<>();
        for (TodoDto todoDto : todoDtoList) {
            todoList.add(todoDto.toDomainModel());
        }
        return todoList;
    }
}