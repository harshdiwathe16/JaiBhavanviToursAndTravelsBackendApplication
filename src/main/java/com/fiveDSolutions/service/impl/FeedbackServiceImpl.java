package com.fiveDSolutions.service.impl;

import com.fiveDSolutions.dto.FeedbackDto;
import com.fiveDSolutions.model.Feedback;
import com.fiveDSolutions.model.ApplicationUsers;
import com.fiveDSolutions.model.TourPackage;
import com.fiveDSolutions.repository.ApplicationUserRepository;
import com.fiveDSolutions.repository.FeedbackRepository;
import com.fiveDSolutions.repository.TourPackageRepository;
import com.fiveDSolutions.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private ApplicationUserRepository usersRepository;

    @Autowired
    private TourPackageRepository packageRepository;

    @Override
    public FeedbackDto addFeedback(FeedbackDto dto) {
        Feedback feedback = mapToEntity(dto);
        return mapToDto(feedbackRepository.save(feedback));
    }

    @Override
    public FeedbackDto updateFeedback(Long feedbackId, FeedbackDto dto) {
        Optional<Feedback> optionalFeedback = feedbackRepository.findById(feedbackId);
        if (!optionalFeedback.isPresent()) {
            throw new RuntimeException("Feedback not found");
        }
        Feedback feedback = optionalFeedback.get();
        feedback.setRating(dto.getRating());
        feedback.setComments(dto.getComments());
        return mapToDto(feedbackRepository.save(feedback));
    }

    @Override
    public void deleteFeedback(Long feedbackId) {
        feedbackRepository.deleteById(feedbackId);
    }

    @Override
    public FeedbackDto getFeedbackById(Long feedbackId) {
        Optional<Feedback> optionalFeedback = feedbackRepository.findById(feedbackId);
        if (!optionalFeedback.isPresent()) {
            throw new RuntimeException("Feedback not found");
        }
        return mapToDto(optionalFeedback.get());
    }

    @Override
    public List<FeedbackDto> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        List<FeedbackDto> dtos = new ArrayList<>();
        for (Feedback feedback : feedbacks) {
            dtos.add(mapToDto(feedback));
        }
        return dtos;
    }

    @Override
    public List<FeedbackDto> getFeedbacksByPackage(Long packageId) {
        TourPackage tourPackage = packageRepository.findById(packageId)
                .orElseThrow(() -> new RuntimeException("Package not found"));
        List<Feedback> feedbacks = feedbackRepository.findByTourPackage(tourPackage);
        List<FeedbackDto> dtos = new ArrayList<>();
        for (Feedback feedback : feedbacks) {
            dtos.add(mapToDto(feedback));
        }
        return dtos;
    }

    @Override
    public List<FeedbackDto> getFeedbacksByCustomer(Long customerId) {
        ApplicationUsers customer = usersRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        List<Feedback> feedbacks = feedbackRepository.findByCustomer(customer);
        List<FeedbackDto> dtos = new ArrayList<>();
        for (Feedback feedback : feedbacks) {
            dtos.add(mapToDto(feedback));
        }
        return dtos;
    }

    private FeedbackDto mapToDto(Feedback feedback) {
        return new FeedbackDto(
                feedback.getFeedbackId(),
                feedback.getCustomer().getApplicationUserId(),
                feedback.getTourPackage().getPackageId(),
                feedback.getRating(),
                feedback.getComments()
        );
    }

    private Feedback mapToEntity(FeedbackDto dto) {
        Feedback feedback = new Feedback();
        feedback.setFeedbackId(dto.getFeedbackId());
        feedback.setRating(dto.getRating());
        feedback.setComments(dto.getComments());

        ApplicationUsers customer = usersRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        TourPackage tourPackage = packageRepository.findById(dto.getPackageId())
                .orElseThrow(() -> new RuntimeException("Package not found"));

        feedback.setCustomer(customer);
        feedback.setTourPackage(tourPackage);
        return feedback;
    }
}
