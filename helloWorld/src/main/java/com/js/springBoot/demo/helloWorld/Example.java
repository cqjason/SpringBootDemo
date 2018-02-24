package com.js.springBoot.demo.helloWorld;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
/**
 * Created by Jason on 2017/9/8.
 */

@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    String home(){
        return "HelloWorld!";
    }

    public static void main(String[] args){
        SpringApplication.run(Example.class,args);
    }
}
