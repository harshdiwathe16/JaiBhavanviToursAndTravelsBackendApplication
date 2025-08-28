package com.fiveDSolutions.controller;

import com.fiveDSolutions.dto.ApiResponseDto;
import com.fiveDSolutions.dto.TourPackageDto;
import com.fiveDSolutions.constants.EOperationStatus;
import com.fiveDSolutions.service.TourPackageService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
public class TourPackageController {

    @Autowired
    private TourPackageService packageService;

//    POST http://localhost:8080/api/packages
    @PostMapping
    public ResponseEntity<ApiResponseDto<TourPackageDto>> createPackage(@Valid @RequestBody TourPackageDto dto) {
        TourPackageDto saved = packageService.createPackage(dto);

        ApiResponseDto<TourPackageDto> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(saved);

        return ResponseEntity.ok(response);
    }

//    PUT http://localhost:8080/api/packages/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto<TourPackageDto>> updatePackage(@PathVariable("id") Long id,
                                                                        @Valid @RequestBody TourPackageDto dto) {
        TourPackageDto updated = packageService.updatePackage(id, dto);

        ApiResponseDto<TourPackageDto> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(updated);

        return ResponseEntity.ok(response);
    }

//    DELETE http://localhost:8080/api/packages/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Void>> deletePackage(@PathVariable("id") Long id) {
        packageService.deletePackage(id);

        ApiResponseDto<Void> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(null);

        return ResponseEntity.ok(response);
    }

//    GET http://localhost:8080/api/packages/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<TourPackageDto>> getPackageById(@PathVariable("id") Long id) {
        TourPackageDto dto = packageService.getPackageById(id);

        ApiResponseDto<TourPackageDto> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(dto);

        return ResponseEntity.ok(response);
    }

//    GET http://localhost:8080/api/packages
    @GetMapping
    public ResponseEntity<ApiResponseDto<List<TourPackageDto>>> getAllPackages() {
        List<TourPackageDto> list = packageService.getAllPackages();

        ApiResponseDto<List<TourPackageDto>> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(list);

        return ResponseEntity.ok(response);
    }
}
