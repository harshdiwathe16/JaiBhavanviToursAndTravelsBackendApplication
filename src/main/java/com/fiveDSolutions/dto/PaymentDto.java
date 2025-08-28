package com.fiveDSolutions.dto;

import com.fiveDSolutions.enums.PaymentStatus;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class PaymentDto {
    private Long paymentId;
    private Long bookingId;        // reference to Booking
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private PaymentStatus paymentStatus;
}
