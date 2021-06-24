package com.CourseBookingSystem.demo.models;


import com.CourseBookingSystem.demo.repositories.CourseRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "courses_and_bookings",
            joinColumns = {@JoinColumn(name = "booking_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "course_id", nullable = false, updatable = false)})
    private List<Course> courses;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customers_id", nullable = false)
    private Customer customer;


    public Booking(String date, Customer customer) {
        this.date = date;
        this.courses = new ArrayList<>();
        this.customer = customer;
    }

    public Booking() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public List<Course> getCourses() {
        return courses;
    }



    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }
}
