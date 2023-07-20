package example.web.presentation.controller.todo;

import example.web.application.service.todo.TodoService;
import example.web.domain.model.todo.Todo;
import example.web.domain.model.todo.TodoList;
import example.web.presentation.controller.todo.form.TodoDetailForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/list")
    String list(Model model) {
        TodoList todoList = todoService.findAll();

        int totalCount = todoList.totalCount();
        int emergencyCount = todoList.emergencyCount();

        model.addAttribute("todoList", todoList.getList());
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("emergencyCount", emergencyCount);
        return "todo/list";
    }

    @GetMapping("/detail")
    String detail(@RequestParam("title") String titleCriteria, Model model) {
        Todo todo = todoService.findByTitle(titleCriteria);
        model.addAttribute("todo", new TodoDetailForm(todo));
        return "todo/detail";
    }

    @GetMapping("/register")
    String register(Model model) {
        model.addAttribute("todo", new Todo());
        return "todo/register";
    }

    @PostMapping("/register")
    String save(Todo todo, Model model) {
        if (!todo.isValid()) {
            model.addAttribute("error", true);
            return "todo/register";
        }
        todoService.saveAsNew(todo);
        return "redirect:/todo/list";
    }
}
