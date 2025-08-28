package com.fiveDSolutions.controller;

import com.fiveDSolutions.dto.ApiResponseDto;
import com.fiveDSolutions.dto.BookingDto;
import com.fiveDSolutions.constants.EOperationStatus;
import com.fiveDSolutions.service.BookingService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<ApiResponseDto<BookingDto>> createBooking(@Valid @RequestBody BookingDto dto) {
        BookingDto saved = bookingService.createBooking(dto);

        ApiResponseDto<BookingDto> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(saved);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto<BookingDto>> updateBooking(@PathVariable("id") Long id,
                                                                    @Valid @RequestBody BookingDto dto) {
        BookingDto updated = bookingService.updateBooking(id, dto);

        ApiResponseDto<BookingDto> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(updated);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Void>> cancelBooking(@PathVariable("id") Long id) {
        bookingService.cancelBooking(id);

        ApiResponseDto<Void> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(null);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<BookingDto>> getBookingById(@PathVariable("id") Long id) {
        BookingDto dto = bookingService.getBookingById(id);

        ApiResponseDto<BookingDto> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(dto);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<BookingDto>>> getAllBookings() {
        List<BookingDto> list = bookingService.getAllBookings();

        ApiResponseDto<List<BookingDto>> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(list);

        return ResponseEntity.ok(response);
    }
}
