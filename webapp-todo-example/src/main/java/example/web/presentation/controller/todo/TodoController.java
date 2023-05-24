package example.web.presentation.controller.todo;

import example.web.application.service.todo.TodoService;
import example.web.domain.model.todo.Todo;
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
        List<Todo> todoList = todoService.findAll();

        int totalCount = todoList.size();
        int emergencyCount = 0;

        for (Todo todo : todoList) {
            // 緊急の件数
            if (todo.getEmergency()) {
                emergencyCount++;
            }
            // 一覧ではタイトルの先頭30文字まで表示する
            if (todo.getTitle().length() > 30) {
                todo.setTitle(todo.getTitle().substring(0, 30) + "...");
            }
        }

        model.addAttribute("todoList", todoList);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("emergencyCount", emergencyCount);
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
    String save(Todo todo, Model model) {
        if (!todo.isValid()) {
            model.addAttribute("error", true);
            return "todo/register";
        }
        todoService.saveAsNew(todo);
        return "redirect:/todo/list";
    }
}
