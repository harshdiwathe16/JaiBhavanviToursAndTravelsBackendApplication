package com.fiveDSolutions.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class FeedbackDto {
    private Long feedbackId;
    private Long customerId;       // reference to User
    private Long packageId;        // reference to TourPackage
    private int rating;            // 1-5
    private String comments;
}
