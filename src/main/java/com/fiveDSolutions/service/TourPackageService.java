package com.fiveDSolutions.service;

import com.fiveDSolutions.dto.TourPackageDto;
import java.util.List;

public interface TourPackageService {
    TourPackageDto createPackage(TourPackageDto dto);
    TourPackageDto updatePackage(Long packageId, TourPackageDto dto);
    void deletePackage(Long packageId);
    TourPackageDto getPackageById(Long packageId);
    List<TourPackageDto> getAllPackages();

    // Extra features
    List<TourPackageDto> searchByDestination(String destination);
    List<TourPackageDto> searchByKeyword(String keyword);
}
