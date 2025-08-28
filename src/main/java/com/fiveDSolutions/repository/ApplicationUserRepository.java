package com.fiveDSolutions.repository;

import com.fiveDSolutions.model.ApplicationUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * File Name: ApplicationUserRepository.java
 * Entity: ApplicationUserRepository
 * Package: com.fiveDSolutions.JaiBhavaniToursAndTravels.repository
 * Author: pranayramteke
 * Date: 28/08/25
 * Description:
 */

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUsers, Long>
{
	Optional<ApplicationUsers> findByEmail(String email);

	boolean existsByEmail(String email);
}
