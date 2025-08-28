package com.fiveDSolutions.service;

import com.fiveDSolutions.dto.ApplicationUsersDto;
import java.util.List;

public interface ApplicationUsersService
{
    ApplicationUsersDto registerUser(ApplicationUsersDto dto);

    ApplicationUsersDto updateUser(Long userId, ApplicationUsersDto dto);

    void deleteUser(Long userId);

    ApplicationUsersDto getUserById(Long userId);

    List<ApplicationUsersDto> getAllUsers();

    // Extra features
    ApplicationUsersDto findByEmail(String email);

    boolean existsByEmail(String email);
}
