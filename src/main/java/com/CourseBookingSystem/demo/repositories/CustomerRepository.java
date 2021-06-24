package com.CourseBookingSystem.demo.repositories;

import com.CourseBookingSystem.demo.models.Course;
import com.CourseBookingSystem.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByName(String gordon);

    List<Customer> findByBookingsCoursesName(String course);
}
