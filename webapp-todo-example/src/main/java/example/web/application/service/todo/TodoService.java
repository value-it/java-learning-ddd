package example.web.application.service.todo;

import example.web.domain.model.todo.Todo;
import example.web.domain.model.todo.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public void saveAsNew(Todo todo) {
        todo.setId(todoRepository.nextId());
        todoRepository.saveAsNew(todo);
    }
}
