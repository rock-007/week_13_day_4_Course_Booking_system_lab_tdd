package com.CourseBookingSystem.demo.componenets;

import com.CourseBookingSystem.demo.models.Booking;
import com.CourseBookingSystem.demo.models.Course;
import com.CourseBookingSystem.demo.models.Customer;
import com.CourseBookingSystem.demo.repositories.BookingRepository;
import com.CourseBookingSystem.demo.repositories.CourseRepository;
import com.CourseBookingSystem.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader() {

    }


    public void run(ApplicationArguments args) throws Exception {
        Customer customer1 = new Customer("Gordon", "Edinburgh", 40);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Umair", "Edinburgh", 37);
        customerRepository.save(customer2);
        Booking booking1 = new Booking("05/07/09", customer1);
        bookingRepository.save(booking1);
        Course python = new Course("Python", "Edinburgh", 5);
        courseRepository.save(python);
        booking1.addCourse(python);
        bookingRepository.save(booking1);


    }
}



