package com.fiveDSolutions.repository;

import com.fiveDSolutions.enums.PaymentStatus;
import com.fiveDSolutions.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByPaymentStatus(PaymentStatus status);
}
