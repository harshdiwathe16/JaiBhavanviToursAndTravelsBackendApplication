package com.fiveDSolutions.repository;

import com.fiveDSolutions.enums.PaymentStatus;
import com.fiveDSolutions.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByPaymentStatus(PaymentStatus status);
}
