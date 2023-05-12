package example.web.presentation.controller.todo.register;

import example.web.application.service.todo.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo/register")
public class TodoRegisterController {

    private final TodoService todoService;

    public TodoRegisterController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    String index(Model model) {
        model.addAttribute("todoRegisterForm", new TodoRegisterForm());
        return "todo/register";
    }

    @PostMapping
    String save(TodoRegisterForm todoRegisterForm, BindingResult result) {
        if (result.hasErrors()) {
            return "todo/register";
        }
        todoService.saveAsNew(todoRegisterForm);
        return "redirect:/todo/list";
    }
}
