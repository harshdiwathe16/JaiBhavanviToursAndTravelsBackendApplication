package com.fiveDSolutions.controller;

import com.fiveDSolutions.dto.ApiResponseDto;
import com.fiveDSolutions.dto.PaymentDto;
import com.fiveDSolutions.constants.EOperationStatus;
import com.fiveDSolutions.service.PaymentService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<ApiResponseDto<PaymentDto>> createPayment(@Valid @RequestBody PaymentDto dto) {
        PaymentDto saved = paymentService.makePayment(dto);

        ApiResponseDto<PaymentDto> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(saved);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto<PaymentDto>> updatePayment(@PathVariable("id") Long id,
                                                                    @Valid @RequestBody PaymentDto dto) {
        PaymentDto updated = paymentService.updatePayment(id, dto);

        ApiResponseDto<PaymentDto> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(updated);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Void>> deletePayment(@PathVariable("id") Long id) {
        paymentService.deletePayment(id);

        ApiResponseDto<Void> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(null);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<PaymentDto>> getPaymentById(@PathVariable("id") Long id) {
        PaymentDto dto = paymentService.getPaymentById(id);

        ApiResponseDto<PaymentDto> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(dto);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<PaymentDto>>> getAllPayments() {
        List<PaymentDto> list = paymentService.getAllPayments();

        ApiResponseDto<List<PaymentDto>> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(list);

        return ResponseEntity.ok(response);
    }
}
