package example.web.application.service.todo;

import example.web.domain.model.todo.Todo;
import example.web.domain.model.todo.TodoList;
import example.web.domain.model.todo.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoList findAll() {
        return todoRepository.findAll();
    }

    public Todo findByTitle(String title) {
        return todoRepository.findByTitle(title);
    }

    public void saveAsNew(Todo todo) {
        todoRepository.saveAsNew(todo);
    }


}
