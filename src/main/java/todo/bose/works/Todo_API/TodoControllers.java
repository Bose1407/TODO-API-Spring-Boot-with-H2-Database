package todo.bose.works.Todo_API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todo.bose.works.Todo_API.Models.Todo;

import java.util.List;

@RestController
public class TodoControllers {

    @Autowired
    private TodoServices todoServices;

    @GetMapping("/")
    public String Home(){
        return "Api Working";
    }

    @PostMapping("/create")
    public Todo createTodo(@RequestBody Todo todo){
        return todoServices.Create(todo);
    }

    @GetMapping("/todos")
    public List<Todo> getTodos(){
        return todoServices.getTodo();
    }

    @PutMapping("/todo/{id}")
    public String updateTodo(@PathVariable Long id,@RequestBody Todo todo){
        return todoServices.Update(id,todo);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id){
        return todoServices.Delete(id);
    }

}
