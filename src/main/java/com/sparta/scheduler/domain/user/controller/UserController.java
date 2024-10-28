package com.sparta.scheduler.domain.user.controller;

import com.sparta.scheduler.domain.user.dto.UserRequestDto;
import com.sparta.scheduler.domain.user.dto.UserResponseDto;
import com.sparta.scheduler.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/scheduler")
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserResponseDto> createUser(
            @RequestBody UserRequestDto userRequestDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(userService.createUser(userRequestDto));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getOneUser(
            @PathVariable Long userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(userService.getOneUser(userId));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Long userId,
            @RequestBody UserRequestDto userRequestDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userService.updateUser(userRequestDto, userId));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long userId) {
        userService.deleteUser(userId);
        try {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

}
