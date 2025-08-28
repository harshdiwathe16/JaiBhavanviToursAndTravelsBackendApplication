package com.fiveDSolutions.service.impl;

import com.fiveDSolutions.dto.PaymentDto;
import com.fiveDSolutions.enums.PaymentStatus;
import com.fiveDSolutions.model.Payment;
import com.fiveDSolutions.model.Booking;
import com.fiveDSolutions.repository.PaymentRepository;
import com.fiveDSolutions.repository.BookingRepository;
import com.fiveDSolutions.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public PaymentDto makePayment(PaymentDto dto) {
        Payment payment = mapToEntity(dto);
        return mapToDto(paymentRepository.save(payment));
    }

    @Override
    public PaymentDto updatePayment(Long paymentId, PaymentDto dto) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        if (!optionalPayment.isPresent()) {
            throw new RuntimeException("Payment not found");
        }
        Payment payment = optionalPayment.get();
        payment.setAmount(dto.getAmount());
        payment.setPaymentDate(dto.getPaymentDate());
        payment.setPaymentStatus(dto.getPaymentStatus());
        return mapToDto(paymentRepository.save(payment));
    }

    @Override
    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public PaymentDto getPaymentById(Long paymentId) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        if (!optionalPayment.isPresent()) {
            throw new RuntimeException("Payment not found");
        }
        return mapToDto(optionalPayment.get());
    }

    @Override
    public List<PaymentDto> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        List<PaymentDto> dtos = new ArrayList<>();
        for (Payment payment : payments) {
            dtos.add(mapToDto(payment));
        }
        return dtos;
    }


    @Override
    public List<PaymentDto> getPaymentsByStatus(PaymentStatus status) {
        List<Payment> payments = paymentRepository.findByPaymentStatus(status);
        List<PaymentDto> dtos = new ArrayList<>();
        for (Payment payment : payments) {
            dtos.add(mapToDto(payment));
        }
        return dtos;
    }

    @Override
    public PaymentDto getPaymentByBooking(Long bookingId) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        if (!optionalBooking.isPresent()) {
            throw new RuntimeException("Booking not found");
        }
        Booking booking = optionalBooking.get();
        if (booking.getPayment() != null) {
            return mapToDto(booking.getPayment());
        }
        return null;
    }

    private PaymentDto mapToDto(Payment payment) {
        return new PaymentDto(
                payment.getPaymentId(),
                payment.getBooking().getBookingId(),
                payment.getAmount(),
                payment.getPaymentDate(),
                payment.getPaymentStatus()
        );
    }

    private Payment mapToEntity(PaymentDto dto) {
        Payment payment = new Payment();
        payment.setPaymentId(dto.getPaymentId());
        payment.setAmount(dto.getAmount());
        payment.setPaymentDate(dto.getPaymentDate());
        payment.setPaymentStatus(dto.getPaymentStatus());

        Booking booking = bookingRepository.findById(dto.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        payment.setBooking(booking);

        return payment;
    }
}
