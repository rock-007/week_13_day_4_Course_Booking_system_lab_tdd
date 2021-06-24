package com.CourseBookingSystem.demo.repositories;

import com.CourseBookingSystem.demo.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
