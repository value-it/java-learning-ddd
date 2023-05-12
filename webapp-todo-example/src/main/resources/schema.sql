DROP SCHEMA IF EXISTS todo CASCADE;
CREATE SCHEMA todo;

DROP SEQUENCE IF EXISTS todo.seq_todo_id;

CREATE SEQUENCE todo.seq_todo_id START WITH 10000 INCREMENT BY 1;

CREATE TABLE todo.todos
(
    id          bigint                   NOT NULL DEFAULT nextval('todo.seq_todo_id') primary key,
    title       character varying(50)    NOT NULL,
    description character varying(100)   NOT NULL,
    emergency   boolean                  NOT NULL,
    priority    integer                  NOT NULL,
    created_at  timestamp with time zone NOT NULL DEFAULT now()
);