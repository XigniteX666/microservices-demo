package com.example.customerregistration.controller;

import com.example.customerregistration.error.UserErrorException;
import com.example.customerregistration.gateway.CustomerRepository;
import com.example.customerregistration.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/all")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        if (customer.getAge() > 18) {
            return customerRepository.save(customer);
        }else{
            throw new UserErrorException();
        }
    }


}
