package com.fiveDSolutions.service.impl;

import com.fiveDSolutions.dto.BookingDto;
import com.fiveDSolutions.enums.BookingStatus;
import com.fiveDSolutions.model.Booking;
import com.fiveDSolutions.model.ApplicationUsers;
import com.fiveDSolutions.model.TourPackage;
import com.fiveDSolutions.repository.ApplicationUserRepository;
import com.fiveDSolutions.repository.BookingRepository;
import com.fiveDSolutions.repository.TourPackageRepository;
import com.fiveDSolutions.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ApplicationUserRepository usersRepository;

    @Autowired
    private TourPackageRepository packageRepository;

    @Override
    public BookingDto createBooking(BookingDto dto) {
        Booking booking = mapToEntity(dto);
        return mapToDto(bookingRepository.save(booking));
    }

    @Override
    public BookingDto updateBooking(Long bookingId, BookingDto dto) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        if (!optionalBooking.isPresent()) {
            throw new RuntimeException("Booking not found");
        }
        Booking booking = optionalBooking.get();
        booking.setBookingDate(dto.getBookingDate());
        booking.setTravelDate(dto.getTravelDate());
        booking.setStatus(dto.getStatus());
        return mapToDto(bookingRepository.save(booking));
    }

    @Override
    public void cancelBooking(Long bookingId) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        if (!optionalBooking.isPresent()) {
            throw new RuntimeException("Booking not found");
        }
        Booking booking = optionalBooking.get();
        booking.setStatus(BookingStatus.CANCELLED);
        bookingRepository.save(booking);
    }

    @Override
    public BookingDto getBookingById(Long bookingId) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        if (!optionalBooking.isPresent()) {
            throw new RuntimeException("Booking not found");
        }
        return mapToDto(optionalBooking.get());
    }

    @Override
    public List<BookingDto> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        List<BookingDto> dtos = new ArrayList<>();
        for (Booking booking : bookings) {
            dtos.add(mapToDto(booking));
        }
        return dtos;
    }

    public List<BookingDto> getBookingsByUsername(String username) {
        List<Booking> bookings = bookingRepository.findByUser_Email(username);

        List<BookingDto> dtoList = new ArrayList<>();
        for (Booking booking : bookings) {
            BookingDto dto = new BookingDto();
            dto.setBookingId(booking.getBookingId());
            dto.setBookingDate(booking.getBookingDate());
//            dto.setTotalAmount(booking.getTotalAmount());
//            dto.setUsername(booking.getUser().getEmail());
            dtoList.add(dto);
        }
        return dtoList;
    }




    private BookingDto mapToDto(Booking booking) {
        return new BookingDto(
                booking.getBookingId(),
                booking.getUser().getApplicationUserId(),
                booking.getTourPackage().getPackageId(),
                booking.getBookingDate(),
                booking.getTravelDate(),
                booking.getStatus()
        );
    }

    private Booking mapToEntity(BookingDto dto) {
        Booking booking = new Booking();
        booking.setBookingId(dto.getBookingId());
        booking.setBookingDate(dto.getBookingDate());
        booking.setTravelDate(dto.getTravelDate());
        booking.setStatus(dto.getStatus());

        ApplicationUsers customer = usersRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        TourPackage tourPackage = packageRepository.findById(dto.getPackageId())
                .orElseThrow(() -> new RuntimeException("Package not found"));

        booking.setUser(customer);
        booking.setTourPackage(tourPackage);
        return booking;
    }
}
