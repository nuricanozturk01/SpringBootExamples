package com.nuricanozturk.springweb01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController
{
    @GetMapping("greeting") //http://192.168.1.35:8080/api/greeting?name=NuriCan&sname=ÖZTÜRK
    public String greeting(String name, @RequestParam("sname") String surname)
    {
        return String.format("Hi! %s - %s", name, surname);
    }
    @GetMapping("hello")
    public String sayHello()
    {
        return "Hello Spring!";
    }

}
