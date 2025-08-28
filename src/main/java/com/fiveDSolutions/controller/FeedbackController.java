package com.fiveDSolutions.controller;

import com.fiveDSolutions.dto.ApiResponseDto;
import com.fiveDSolutions.dto.FeedbackDto;
import com.fiveDSolutions.constants.EOperationStatus;
import com.fiveDSolutions.service.FeedbackService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<ApiResponseDto<FeedbackDto>> createFeedback(@Valid @RequestBody FeedbackDto dto) {
        FeedbackDto saved = feedbackService.addFeedback(dto);

        ApiResponseDto<FeedbackDto> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(saved);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto<FeedbackDto>> updateFeedback(@PathVariable("id") Long id,
                                                                      @Valid @RequestBody FeedbackDto dto) {
        FeedbackDto updated = feedbackService.updateFeedback(id, dto);

        ApiResponseDto<FeedbackDto> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(updated);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Void>> deleteFeedback(@PathVariable("id") Long id) {
        feedbackService.deleteFeedback(id);

        ApiResponseDto<Void> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(null);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<FeedbackDto>> getFeedbackById(@PathVariable("id") Long id) {
        FeedbackDto dto = feedbackService.getFeedbackById(id);

        ApiResponseDto<FeedbackDto> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(dto);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<FeedbackDto>>> getAllFeedbacks() {
        List<FeedbackDto> list = feedbackService.getAllFeedbacks();

        ApiResponseDto<List<FeedbackDto>> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(list);

        return ResponseEntity.ok(response);
    }
}
