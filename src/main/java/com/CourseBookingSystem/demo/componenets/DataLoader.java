package com.CourseBookingSystem.demo.componenets;

import com.CourseBookingSystem.demo.models.Customer;
import com.CourseBookingSystem.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

public class DataLoader implements ApplicationRunner {


    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {

    }


    public void run(ApplicationArguments args) throws Exception {
        Customer customer1 = new Customer("Gordon", "Edinburgh", 40);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Umair", "Edinburgh", 37);
        customerRepository.save(customer2);

    }
}



