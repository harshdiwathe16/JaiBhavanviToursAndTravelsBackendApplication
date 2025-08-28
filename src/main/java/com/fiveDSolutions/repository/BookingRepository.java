package com.fiveDSolutions.repository;

import com.fiveDSolutions.enums.BookingStatus;
import com.fiveDSolutions.model.ApplicationUsers;
import com.fiveDSolutions.model.Booking;
import com.fiveDSolutions.model.User;
import com.fiveDSolutions.constants.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomer(ApplicationUsers customer);
    List<Booking> findByStatus(BookingStatus status);
}
