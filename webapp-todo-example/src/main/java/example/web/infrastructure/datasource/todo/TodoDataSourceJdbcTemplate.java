package example.web.infrastructure.datasource.todo;

import example.web.domain.model.todo.Todo;
import example.web.domain.model.todo.TodoList;
import example.web.domain.model.todo.TodoRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Primary
public class TodoDataSourceJdbcTemplate implements TodoRepository {

    private JdbcTemplate jdbcTemplate;

    public TodoDataSourceJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TodoList findAll() {
        List<Todo> todoList = new ArrayList<>();

        String query = "SELECT id, title, description, emergency, priority FROM todo.todos";
        System.out.println(query);

        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(query);

        for (Map<String, Object> record : resultList) {
            Todo todo = new Todo();
            todo.setId((Long) record.get("id"));
            todo.setTitle((String) record.get("title"));
            todo.setDescription((String) record.get("description"));
            todo.setEmergency((Boolean) record.get("emergency"));
            todo.setPriority(record.get("priority").toString());
            todoList.add(todo);
        }
        return new TodoList(todoList);
    }

    @Override
    public Todo findByTitle(String title) {
        String query = "SELECT id, title, description, emergency, priority FROM todo.todos WHERE title = '" + title + "'";
        System.out.println(query);

        Map<String, Object> result = jdbcTemplate.queryForMap(query);

        Todo todo = new Todo();
        todo.setId((Long) result.get("id"));
        todo.setTitle((String) result.get("title"));
        todo.setDescription((String) result.get("description"));
        todo.setEmergency((Boolean) result.get("emergency"));
        todo.setPriority(result.get("priority").toString());

        return todo;
    }

    @Override
    public void saveAsNew(Todo todo) {
        Long nextId = nextId();
        String queryFormat = "INSERT INTO todo.todos(id, title, description, emergency, priority) VALUES(%d, '%s', '%s', %b, %s)";
        String query = String.format(queryFormat,
                nextId,
                todo.getTitle(),
                todo.getDescription(),
                todo.getEmergency(),
                todo.getPriority());
        System.out.println(query);

        jdbcTemplate.update(query);
    }

    private Long nextId() {
        String query = "SELECT nextval('todo.seq_todo_id') AS id";
        System.out.println(query);

        Map<String, Object> result = jdbcTemplate.queryForMap(query);

        return (Long) result.get("id");
    }

}
