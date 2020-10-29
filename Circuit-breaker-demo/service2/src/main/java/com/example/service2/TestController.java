package com.example.service2;

import com.example.service2.model.Person;
import com.example.service2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/service2")
@CrossOrigin("*")
public class TestController {

    @Autowired
    private PersonService personService;

    @Bean
    public RestTemplate rest(RestTemplateBuilder builder){
        return builder.build();
    }

    @GetMapping("greeting")
    public String getGreeting() {

        Person p1 = personService.getPersonFromService1();
        return "Hello, " + p1.getFirstName();
    }


}
