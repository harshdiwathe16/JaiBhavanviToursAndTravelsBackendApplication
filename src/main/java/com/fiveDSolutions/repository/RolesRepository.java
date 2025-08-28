package com.fiveDSolutions.repository;

import com.fiveDSolutions.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * File Name: RolesRepository.java
 * Entity: RolesRepository
 * Package: com.fiveDSolutions.JaiBhavaniToursAndTravels.repository
 * Author: pranayramteke
 * Date: 28/08/25
 * Description:
 */

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>
{
	Optional<Roles> findByRoleName(String name);
}
