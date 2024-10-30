package com.sparta.scheduler.domain.user.controller;

import com.sparta.scheduler.domain.common.exception.ResponseException;
import com.sparta.scheduler.domain.user.dto.UserRequestDto;
import com.sparta.scheduler.domain.user.dto.UserResponseDto;
import com.sparta.scheduler.domain.user.service.UserService;
import jakarta.validation.Valid;
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
            @RequestBody @Valid UserRequestDto userRequestDto) throws ResponseException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(userRequestDto));

    }

    @GetMapping("/userId={userId}")
    public ResponseEntity<UserResponseDto> getOneUser(
            @PathVariable Long userId) throws ResponseException {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getOneUser(userId));
    }

    @GetMapping("/userList")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() throws ResponseException {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAllUsers());

    }

    @PutMapping("/userId={userId}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Long userId,
            @RequestBody @Valid UserRequestDto userRequestDto) throws ResponseException {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.updateUser(userRequestDto, userId));

    }

    @DeleteMapping("/userId={userId}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long userId) throws ResponseException {

        userService.deleteUser(userId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();

    }

}
