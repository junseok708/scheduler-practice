package com.sparta.scheduler.domain.user.service;

import com.sparta.scheduler.domain.task.entity.Task;
import com.sparta.scheduler.domain.task.repository.TaskRepository;
import com.sparta.scheduler.domain.user.dto.UserRequestDto;
import com.sparta.scheduler.domain.user.dto.UserResponseDto;
import com.sparta.scheduler.domain.user.entity.User;
import com.sparta.scheduler.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRep;


    public UserResponseDto createUser(
            UserRequestDto userRequestDto) {
        User user = new User();
        user.init(userRequestDto);
        userRep.save(user);
        return user.to();
    }

    public UserResponseDto getOneUser(Long userId) {
        User user = userRep.findByUser(userId);
        return user.to();
    }

    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRep.findAll();
        return users
                .stream()
                .map(User::to)
                .toList();
    }


    public UserResponseDto updateUser(UserRequestDto userReq, Long userId) {
        User user = userRep.findByUser(userId);
        user.updateDate(userReq);
        userRep.save(user);
        user = userRep.findByUser(userId);
        return user.to();
    }

    @Transactional
    public void deleteUser(Long userId) {
        User user = userRep.findByUser(userId);
        userRep.deleteById(user.getId());
    }

}
