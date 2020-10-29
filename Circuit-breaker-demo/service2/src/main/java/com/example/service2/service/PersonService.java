package com.example.service2.service;

import com.example.service2.model.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class PersonService {
    private final RestTemplate restTemplate;
    private final String service1URL = "http://localhost:8081/service1/test";


    public PersonService(RestTemplate rest){
        this.restTemplate = rest;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public Person getPersonFromService1(){
        System.out.println("Calling the service method");
        RestTemplate restTemplate = new RestTemplate();
        URI uri = URI.create(service1URL);
        Person p1 = restTemplate.getForObject(uri, Person.class);
        return p1;
    }

    public Person reliable(){
        System.out.println("Calling the default method");
        return new Person("Default", "User");
    }
}
