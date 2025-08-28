package com.fiveDSolutions.repository;

import com.fiveDSolutions.enums.BookingStatus;
import com.fiveDSolutions.model.ApplicationUsers;
import com.fiveDSolutions.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUsername(ApplicationUsers username);
    List<Booking> findByStatus(BookingStatus status);
}
