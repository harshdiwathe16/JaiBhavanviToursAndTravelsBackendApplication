package com.fiveDSolutions.repository;

import com.fiveDSolutions.model.ApplicationUsers;
import com.fiveDSolutions.model.Feedback;
import com.fiveDSolutions.model.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByTourPackage(TourPackage tourPackage);
    List<Feedback> findByCustomer(ApplicationUsers customer);
}
