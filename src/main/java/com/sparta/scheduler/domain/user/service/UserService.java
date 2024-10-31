package com.sparta.scheduler.domain.user.service;

import com.sparta.scheduler.domain.comment.service.CommentService;
import com.sparta.scheduler.domain.common.exception.ExceptionMethod;
import com.sparta.scheduler.domain.common.exception.ResponseException;
import com.sparta.scheduler.domain.task.service.TaskService;
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
public class UserService extends ExceptionMethod {

    private final UserRepository userRep;
    private final CommentService commentService;
    private final TaskService taskService;


    public UserResponseDto createUser(
            UserRequestDto userReq) throws ResponseException {
        isNull(userReq);
        User user = new User();
        user.init(userReq);
        userRep.save(user);
        return user.to();
    }

    public UserResponseDto getOneUser(Long userId) throws ResponseException {
        User user = userRep.findByUser(userId);
        return user.to();
    }

    public List<UserResponseDto> getAllUsers() throws ResponseException {
        List<User> users = userRep.findAll();
        return users
                .stream()
                .map(User::to)
                .toList();
    }

    @Transactional
    public UserResponseDto updateUser(
            UserRequestDto userReq, Long userId) throws ResponseException {
        User user = userRep.findByUser(userId);
        user.updateDate(userReq);
        return user.to();
    }

    @Transactional
    public void deleteUser(Long userId) throws ResponseException {
        userRep.findByUser(userId);
        commentService.deleteByUser(userId);
        taskService.deleteByUser(userId);
        userRep.deleteById(userId);
    }

}
