package com.fiveDSolutions.dto;

import lombok.*;
import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class TourPackageDto {
    private Long packageId;
    private String packageName;
    private String description;
    private String destination;
    private String durationDays;
    private Double price;

    public TourPackageDto(Long packageId, String packageName, String destination, Double price, String description) {
    }
}
