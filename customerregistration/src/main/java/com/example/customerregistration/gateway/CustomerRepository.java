package com.example.customerregistration.gateway;

import com.example.customerregistration.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
