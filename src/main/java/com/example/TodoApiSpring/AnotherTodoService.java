package com.example.TodoApiSpring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("anothertodoservice")

public class AnotherTodoService implements TodoService{
    @TimeMonitor
    public String doSomething(){
        for(long i=0;i<1e9;i++) {}
        return "something";
    }
}
