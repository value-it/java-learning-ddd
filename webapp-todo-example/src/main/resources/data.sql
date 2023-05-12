DELETE
FROM todo.todos;

INSERT INTO todo.todos(id, title, description, emergency)
VALUES (10001, 'ラジオ体操をする', 'とりあえず1週間続ける', false),
       (10002, '7つの習慣を読み終える', '5月中に!!', true);

ALTER SEQUENCE todo.seq_todo_id RESTART WITH 10003;