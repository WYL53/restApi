package com.example.learn.restApi.asyn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("/asyn")
public class AsynController {

    @GetMapping("/task")
    public Callable<String> task(){
        System.out.println("start task");
        Callable<String> rest = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "success";
            }
        };
        System.out.println("exit task");
        return rest;
    }

    @GetMapping("/task2")
    public DeferredResult<String> task2(){
        System.out.println("start task");
        DeferredResult<String> rest = new DeferredResult<>();
        System.out.println("exit task");
        return rest;
    }
}
