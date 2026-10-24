package com.example.TodoApiSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
public class TodoController {
    private List<Todo> todoList;

//    @Autowired
//    @Qualifier("anothertodoservice")
//    private TodoService todoServies;

    private TodoService todoServies1;//anothertodoservice
    private TodoService todoServies2;//faketodoservice

    public TodoController(@Qualifier("anothertodoservice") TodoService todoServies1,
                          @Qualifier("faketodoservice") TodoService todoServies2 ){
        todoList=new ArrayList<>();
        todoList.add(new Todo(1,true,"sahil",1));
        todoList.add(new Todo(2,false,"ayush",2));
        this.todoServies1=todoServies1;
        this.todoServies2=todoServies2;

    }

    @GetMapping("/todo")
    public List<Todo> getAllTodo(@RequestParam(required = false,defaultValue = "true") boolean isCompleted){
        System.out.println(todoServies1.doSomething());
        System.out.println("input params "+isCompleted);
        return todoList;
    }

    @PostMapping("/todo")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newtodo){
        todoList.add(newtodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newtodo);
    }

    @GetMapping("/todo/{todoId}")
    public ResponseEntity<?> getTodo(@PathVariable int todoId){
        for(Todo t:todoList){
            if(t.getId()==todoId){
                return  ResponseEntity.ok(t);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("todo not found");
    }

//    @GetMapping("/todo")
//    public List<Todo> getAllTodo(){
//        return todoList;
//    }
//
//    @PostMapping("/todo")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Todo createTodo(@RequestBody Todo newTodo){
//        todoList.add(newTodo);
//        return newTodo;
//    }

}
