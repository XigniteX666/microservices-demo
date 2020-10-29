package com.example.service1.controller;

import com.example.service1.model.Person;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service1")
@CrossOrigin("*")
public class TestController {

    @GetMapping("test")
    public Person test(){
        return new Person("Oskar", "Albers");
    }


}
