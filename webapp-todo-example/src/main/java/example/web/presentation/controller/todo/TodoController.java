package example.web.presentation.controller.todo;

import example.web.application.service.todo.TodoService;
import example.web.domain.model.todo.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
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
        List<Todo> todoList = todoService.findAll();
        model.addAttribute("todoList", todoList);
        model.addAttribute("totalCount", todoList.size());
        model.addAttribute("emergencyCount", todoList.stream().filter(todo -> todo.getEmergency()).count());
        return "todo/list";
    }

    @GetMapping("/detail")
    String detail(@RequestParam("title") String titleCriteria, Model model) {
        model.addAttribute("todo", todoService.findByTitle(titleCriteria));
        return "todo/detail";
    }

    @GetMapping("/register")
    String register(Model model) {
        model.addAttribute("todo", new Todo());
        return "todo/register";
    }

    @PostMapping("/register")
    String save(@Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo/register";
        }
        todoService.saveAsNew(todo);
        return "redirect:/todo/list";
    }
}
