package todo.bose.works.Todo_API;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.bose.works.Todo_API.Models.Todo;

public interface TodoRepositry extends JpaRepository<Todo,Long> { }