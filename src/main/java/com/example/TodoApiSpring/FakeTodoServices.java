package com.example.TodoApiSpring;


import org.springframework.stereotype.Service;

@Service("faketodoservice")
public class FakeTodoServices implements TodoService {
    public String doSomething(){
        return "something";
    }
}
