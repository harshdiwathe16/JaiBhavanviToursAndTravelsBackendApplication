package com.fiveDSolutions.repository;

import com.fiveDSolutions.model.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourPackageRepository extends JpaRepository<TourPackage, Long> {
    List<TourPackage> findByDestination(String destination);
    List<TourPackage> findByPackageNameContainingIgnoreCase(String keyword);
}
