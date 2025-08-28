package com.fiveDSolutions.service;

import com.fiveDSolutions.dto.BookingDto;
import com.fiveDSolutions.enums.BookingStatus;

import java.util.List;

public interface BookingService
{
    BookingDto createBooking(BookingDto dto);

    BookingDto updateBooking(Long bookingId, BookingDto dto);

    void cancelBooking(Long bookingId);

    BookingDto getBookingById(Long bookingId);

    List<BookingDto> getAllBookings();

    // Extra features

    List<BookingDto> getBookingsByUsername(String Username);
}
