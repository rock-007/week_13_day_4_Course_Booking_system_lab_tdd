package com.CourseBookingSystem.demo;

import com.CourseBookingSystem.demo.models.Course;
import com.CourseBookingSystem.demo.models.Customer;
import com.CourseBookingSystem.demo.repositories.BookingRepository;
import com.CourseBookingSystem.demo.repositories.CourseRepository;
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
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    BookingRepository bookingRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void addCustomer() {
        Customer customer1 = new Customer("Gordon", "Edinburgh", 40);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Umair", "Edinburgh", 37);
        customerRepository.save(customer2);
        assertEquals("Gordon", customerRepository.findByName("Gordon").get(0).getName());

    }

    @Test
    public void canGetAllCoursesWithGivenRating() {
       assertEquals("Python",courseRepository.findByStarRating(5).get(0).getName());
    }
    @Test
    public void canGetAllCustomersForGivenCourse (){

       assertEquals("Gordon",customerRepository.findByBookingsCoursesName("Python").get(0).getName());


    }
    @Test
    public void canGetAllCoursesForGivenCustomer (){
         assertEquals("Python",courseRepository.findByBookingsCustomerName("Gordon").get(0).getName());


    }
    @Test
    public void canGetAllBookingsForGivenDate (){
         assertEquals(1,bookingRepository.findByDate("05/07/09").size());


    }

    @Test
    public void canGetAllCustomersForGivenTownAndCourse (){
         assertEquals(1,customerRepository.getByTownAndBookingsCoursesName("Edinburgh","Python").size());


    }
    @Test
    public void canGetAllCustomersForCertainAgeSpecifcTownAndGivenCourse (){
        assertEquals(1,customerRepository.getByAgeGreaterThanAndTownAndBookingsCoursesName(38,"Edinburgh","Python").size());


    }

}
