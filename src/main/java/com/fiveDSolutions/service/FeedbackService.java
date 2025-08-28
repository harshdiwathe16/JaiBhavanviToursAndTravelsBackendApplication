package com.fiveDSolutions.service;

import com.fiveDSolutions.dto.FeedbackDto;
import java.util.List;

public interface FeedbackService
{
    FeedbackDto addFeedback(FeedbackDto dto);

    FeedbackDto updateFeedback(Long feedbackId, FeedbackDto dto);

    void deleteFeedback(Long feedbackId);

    FeedbackDto getFeedbackById(Long feedbackId);

    List<FeedbackDto> getAllFeedbacks();

    // Extra features

    List<FeedbackDto> getFeedbacksByPackage(Long packageId);

    List<FeedbackDto> getFeedbacksByCustomer(Long customerId);
}
