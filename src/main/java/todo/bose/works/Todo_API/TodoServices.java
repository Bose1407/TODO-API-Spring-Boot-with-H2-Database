package todo.bose.works.Todo_API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.bose.works.Todo_API.Models.Todo;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServices {

    @Autowired
    private TodoRepositry todoRepositry;

    public Todo Create(Todo todo) {
        return todoRepositry.save(todo);
    }

    public List<Todo> getTodo(){
        return todoRepositry.findAll();
    }

    public String Update(Long id ,Todo todo){

        return todoRepositry.findById(id).map(_todo->{
            _todo.setTitle(todo.getTitle());
            _todo.setDesc(todo.getDesc());
            _todo.setCompleted(todo.isCompleted());
            todoRepositry.save(_todo);
            return "Todo Updated Successfully";
        }).orElse("No Todo with id "+id+" Found");


    }

    public String Delete(Long id){
       if(todoRepositry.existsById(id)){
           todoRepositry.deleteById(id);
           return "Todo Deleted Sucessfully";
       }

       return "Todo with id "+id+" not found";
    }
}
