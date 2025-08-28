package com.fiveDSolutions.service;

import com.fiveDSolutions.dto.PaymentDto;
import com.fiveDSolutions.enums.PaymentStatus;

import java.util.List;

public interface PaymentService {
    PaymentDto makePayment(PaymentDto dto);
    PaymentDto updatePayment(Long paymentId, PaymentDto dto);
    void deletePayment(Long paymentId);
    PaymentDto getPaymentById(Long paymentId);
    List<PaymentDto> getAllPayments();

    // Extra features
    List<PaymentDto> getPaymentsByStatus(PaymentStatus status);
    PaymentDto getPaymentByBooking(Long bookingId);
}
