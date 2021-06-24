package com.CourseBookingSystem.demo.models;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    private String town;
    @Column(name = "star_rating")
    private int starRating;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "courses_and_bookings",
            joinColumns = {@JoinColumn(name = "course_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "booking_id", nullable = false, updatable = false)})
    private List<Booking> bookings;

    public Course(String name, String town, int starRating) {
        this.name = name;
        this.town = town;
        this.starRating = starRating;
        this.bookings = new ArrayList<>();
    }

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Booking bookings) {
        this.bookings.add(bookings);
    }
}
