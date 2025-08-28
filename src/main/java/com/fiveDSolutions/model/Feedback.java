package com.fiveDSolutions.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "feedbacks")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private ApplicationUsers customer;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private TourPackage tourPackage;

    private int rating; // 1-5
    private String comments;
}
