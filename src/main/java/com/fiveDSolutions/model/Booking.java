package com.fiveDSolutions.model;

import com.fiveDSolutions.enums.BookingStatus;
import com.fiveDSolutions.model.ApplicationUsers;
import com.fiveDSolutions.model.Payment;
import com.fiveDSolutions.model.Roles;
import jakarta.persistence.*;
import lombok.*;

import javax.management.relation.Role;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private ApplicationUsers user;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private TourPackage tourPackage;

    private LocalDate bookingDate;

    private LocalDate travelDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;  // CONFIRMED, CANCELLED, PENDING

    // Relationships
    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;
}
