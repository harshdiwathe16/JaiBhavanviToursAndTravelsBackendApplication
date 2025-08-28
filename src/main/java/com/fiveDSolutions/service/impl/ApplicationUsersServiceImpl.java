package com.fiveDSolutions.service.impl;

import com.fiveDSolutions.dto.ApplicationUsersDto;
import com.fiveDSolutions.model.ApplicationUsers;
import com.fiveDSolutions.repository.ApplicationUserRepository;
import com.fiveDSolutions.service.ApplicationUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUsersServiceImpl implements ApplicationUsersService {

    @Autowired
    private ApplicationUserRepository userRepository;

    private ApplicationUsersDto mapToDto(ApplicationUsers user) {
        return new ApplicationUsersDto(
                user.getApplicationUserId(),
                user.getUserName(),
                user.getEmail(),
                user.getMobileNumber(),
                user.getRole()
        );
    }

        private ApplicationUsers mapToEntity(ApplicationUsersDto dto) {
            ApplicationUsers user = new ApplicationUsers();
            user.setUserName(dto.getUserName());
            user.setUserName(dto.getUserName());
            user.setEmail(dto.getEmail());
            user.setMobileNumber(dto.getMobileNumber());
            user.setRole(dto.getRole());
            return user;
        }

    @Override
    public ApplicationUsersDto registerUser(ApplicationUsersDto dto) {
        ApplicationUsers user = mapToEntity(dto);
        return mapToDto(userRepository.save(user));
    }

    @Override
    public ApplicationUsersDto updateUser(Long userId, ApplicationUsersDto dto) {
        Optional<ApplicationUsers> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("User not found");
        }
        ApplicationUsers user = optionalUser.get();
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setMobileNumber(dto.getMobileNumber());
        user.setRole(dto.getRole());
        return mapToDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public ApplicationUsersDto getUserById(Long userId) {
        Optional<ApplicationUsers> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("User not found");
        }
        return mapToDto(optionalUser.get());
    }

    @Override
    public List<ApplicationUsersDto> getAllUsers() {
        List<ApplicationUsers> users = userRepository.findAll();
        List<ApplicationUsersDto> dtos = new ArrayList<>();
        for (ApplicationUsers user : users) {
            dtos.add(mapToDto(user));
        }
        return dtos;
    }

    @Override
    public ApplicationUsersDto findByEmail(String email) {
        Optional<ApplicationUsers> optionalUser = userRepository.findByEmail(email);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("User not found");
        }
        return mapToDto(optionalUser.get());
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }


    }
