package com.fiveDSolutions.model;

import com.fiveDSolutions.enums.BookingStatus;
//import com.fiveDSolutions.model.Booking;
import com.fiveDSolutions.model.Feedback;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tour_packages")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString(exclude = {"bookings", "feedbacks"})
public class TourPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packageId;

    private String packageName;

    private String description;

    private String destination;

    private String durationDays;

    private Double price;

//     Relationships
    @OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbacks;
}
