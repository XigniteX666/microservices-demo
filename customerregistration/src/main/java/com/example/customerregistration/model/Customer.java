package com.example.customerregistration.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Customer {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;

}
