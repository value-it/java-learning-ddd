package example.web.presentation.controller.todo.list;

import example.web.application.service.todo.TodoService;
import example.web.domain.model.todo.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/todo/list")
public class TodoListController {

    private final TodoService todoService;

    public TodoListController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    String index(Model model) {
        List<Todo> todoList = todoService.findAll();
        model.addAttribute("todoList", todoList);
        model.addAttribute("totalCount", todoList.size());
        model.addAttribute("emergencyCount", todoList.stream().filter(todo -> todo.isEmergency()).count());
        return "todo/list";
    }
}
