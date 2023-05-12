package example.web.infrastructure.datasource.todo;

import example.web.domain.model.todo.Todo;
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
    public List<Todo> findAll() {
        List<Todo> todoList = new ArrayList<>();

        String query = "SELECT id, title, description, emergency FROM todo.todos";

        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(query);

        for (Map<String, Object> record : resultList) {
            Todo todo = new Todo();
            todo.setId((Long) record.get("id"));
            todo.setTitle((String) record.get("title"));
            todo.setDescription((String) record.get("description"));
            todo.setEmergency((Boolean) record.get("emergency"));
            todoList.add(todo);
        }
        return todoList;
    }

    @Override
    public Long nextId() {
        String query = "SELECT nextval('todo.seq_todo_id') AS id";
        Map<String, Object> result = jdbcTemplate.queryForMap(query);
        return (Long) result.get("id");
    }

    @Override
    public void saveAsNew(Todo todo) {
        String queryFormat = "INSERT INTO todo.todos(id, title, description, emergency) VALUES(%d, '%s', '%s', %b)";
        String query = String.format(queryFormat,
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getEmergency());
        jdbcTemplate.update(query);
    }
}
