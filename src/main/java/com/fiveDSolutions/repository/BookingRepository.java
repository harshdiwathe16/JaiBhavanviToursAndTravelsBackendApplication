package com.fiveDSolutions.repository;

import com.fiveDSolutions.enums.BookingStatus;
import com.fiveDSolutions.model.ApplicationUsers;
import com.fiveDSolutions.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Correct way: find bookings by user entity
    List<Booking> findByUser(ApplicationUsers user);

    // OR if you want by email directly:
    List<Booking> findByUser_Email(String email);
}
