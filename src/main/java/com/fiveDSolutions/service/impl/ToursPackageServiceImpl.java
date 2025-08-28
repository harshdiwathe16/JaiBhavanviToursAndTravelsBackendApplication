package com.fiveDSolutions.service.impl;

import com.fiveDSolutions.dto.TourPackageDto;
import com.fiveDSolutions.model.TourPackage;
import com.fiveDSolutions.repository.TourPackageRepository;
import com.fiveDSolutions.service.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToursPackageServiceImpl implements TourPackageService
{
    @Autowired
    private TourPackageRepository tourPackageRepository;

    // Helper: Convert Entity -> DTO
    private TourPackageDto toDto(TourPackage entity) {
        return new TourPackageDto(entity.getPackageId(), entity.getPackageName(), entity.getDestination(), entity.getPrice(), entity.getDescription());
    }

    // Helper: Convert DTO -> Entity
    private TourPackage toEntity(TourPackageDto dto) {
        TourPackage entity = new TourPackage();
        entity.setPackageId(dto.getPackageId());
        entity.setPackageName(dto.getPackageName());
        entity.setDestination(dto.getDestination());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    @Override
    public TourPackageDto createPackage(TourPackageDto dto) {
        TourPackage entity = toEntity(dto);
        TourPackage saved = tourPackageRepository.save(entity);
        return toDto(saved);
    }

    @Override
    public TourPackageDto updatePackage(Long packageId, TourPackageDto dto) {
        Optional<TourPackage> optional = tourPackageRepository.findById(packageId);
        if (optional.isEmpty()) {
            throw new RuntimeException("Package not found with id " + packageId);
        }
        TourPackage entity = optional.get();
        entity.setPackageName(dto.getPackageName());
        entity.setDestination(dto.getDestination());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());

        TourPackage updated = tourPackageRepository.save(entity);
        return toDto(updated);
    }

    @Override
    public void deletePackage(Long packageId) {
        tourPackageRepository.deleteById(packageId);
    }

    @Override
    public TourPackageDto getPackageById(Long packageId) {
        TourPackage entity = tourPackageRepository.findById(packageId)
                .orElseThrow(() -> new RuntimeException("Package not found with id " + packageId));
        return toDto(entity);
    }

    @Override
    public List<TourPackageDto> getAllPackages() {
        List<TourPackage> entities = tourPackageRepository.findAll();
        List<TourPackageDto> dtos = new java.util.ArrayList<>();
        for (TourPackage entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    @Override
    public List<TourPackageDto> searchByDestination(String destination) {
        List<TourPackage> entities = tourPackageRepository.findByDestinationContainingIgnoreCase(destination);
        List<TourPackageDto> dtos = new java.util.ArrayList<>();
        for (TourPackage entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    @Override
    public List<TourPackageDto> searchByKeyword(String keyword) {
        List<TourPackage> entities =
                tourPackageRepository.findByPackageNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);

        List<TourPackageDto> dtos = new ArrayList<>();
        for (TourPackage entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
