package com.fiveDSolutions.dto;

import com.fiveDSolutions.enums.BookingStatus;
import lombok.*;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class BookingDto {
    private Long bookingId;
    private Long customerId;      // reference to User
    private Long packageId;       // reference to TourPackage
    private LocalDate bookingDate;
    private LocalDate travelDate;
    private com.fiveDSolutions.enums.BookingStatus status;
}
