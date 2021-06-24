package com.CourseBookingSystem.demo;

import com.CourseBookingSystem.demo.models.Customer;
import com.CourseBookingSystem.demo.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void addCustomer() {
        Customer customer1 = new Customer("Gordon", "Edinburgh", 40);
        Customer customer2 = new Customer("Umair", "Edinburgh", 37);

        customerRepository.save(customer1);

        assertEquals("Gordon", customerRepository.findByName("Gordon").get(0).getName());

    }

}
