DELETE
FROM todo.todos;

INSERT INTO todo.todos(id, title, description, emergency, priority)
VALUES (10001, 'ラジオ体操をする', 'とりあえず1週間続ける', false, 1),
       (10002, '7つの習慣を読み終える', '5月中に!!', true, 5);

ALTER SEQUENCE todo.seq_todo_id RESTART WITH 10003;