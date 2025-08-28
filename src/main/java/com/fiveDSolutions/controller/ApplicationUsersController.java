package com.fiveDSolutions.controller;

import com.fiveDSolutions.dto.ApiResponseDto;
import com.fiveDSolutions.dto.ApplicationUsersDto;
import com.fiveDSolutions.constants.EOperationStatus;
import com.fiveDSolutions.service.ApplicationUsersService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class ApplicationUsersController {

    @Autowired
    private ApplicationUsersService userService;


    @PostMapping
    public ResponseEntity<ApiResponseDto<ApplicationUsersDto>> registerUser(@Valid @RequestBody ApplicationUsersDto dto) {
        ApplicationUsersDto saved = userService.registerUser(dto);

        ApiResponseDto<ApplicationUsersDto> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(saved);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto<ApplicationUsersDto>> updateUser(@PathVariable("id") Long userId,
                                                                          @Valid @RequestBody ApplicationUsersDto dto) {
        ApplicationUsersDto updated = userService.updateUser(userId, dto);

        ApiResponseDto<ApplicationUsersDto> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(updated);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Void>> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);

        ApiResponseDto<Void> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(null);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<ApplicationUsersDto>> getUserById(@PathVariable("id") Long userId) {
        ApplicationUsersDto dto = userService.getUserById(userId);

        ApiResponseDto<ApplicationUsersDto> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(dto);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<ApplicationUsersDto>>> getAllUsers() {
        List<ApplicationUsersDto> list = userService.getAllUsers();

        ApiResponseDto<List<ApplicationUsersDto>> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(list);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/email/{email}")
    public ResponseEntity<ApiResponseDto<ApplicationUsersDto>> findByEmail(@PathVariable("email") String email) {
        ApplicationUsersDto dto = userService.findByEmail(email);

        ApiResponseDto<ApplicationUsersDto> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(dto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/exists/{email}")
    public ResponseEntity<ApiResponseDto<Boolean>> existsByEmail(@PathVariable("email") String email) {
        boolean exists = userService.existsByEmail(email);

        ApiResponseDto<Boolean> response = new ApiResponseDto<>();
        response.setStatus(EOperationStatus.RESULT_SUCCESS);
        response.setData(exists);

        return ResponseEntity.ok(response);
    }
}
