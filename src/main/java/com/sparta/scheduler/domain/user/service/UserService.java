package com.sparta.scheduler.domain.user.service;

import com.sparta.scheduler.domain.comment.repository.CommentRepository;
import com.sparta.scheduler.domain.common.exception.ResponseException;
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
    private final TaskRepository taskRep;
    private final CommentRepository commentRep;


    public UserResponseDto createUser(
            UserRequestDto userRequestDto) throws ResponseException {
        User user = new User();
        user.init(userRequestDto);
        userRep.save(user);
        return user.to();
    }

    public UserResponseDto getOneUser(Long userId) throws ResponseException {
        User user = userRep.findByUser(userId);
        return user.to();
    }

    public List<UserResponseDto> getAllUsers() throws ResponseException{
        List<User> users = userRep.findAll();
        return users
                .stream()
                .map(User::to)
                .toList();
    }


    public UserResponseDto updateUser(UserRequestDto userReq, Long userId) throws ResponseException{
        User user = userRep.findByUser(userId);
        user.updateDate(userReq);
        userRep.save(user);
        user = userRep.findByUser(userId);
        return user.to();
    }

    @Transactional
    public void deleteUser(Long userId) throws ResponseException {
        userRep.findByUser(userId);
        commentRep.deleteByUserId(userId);
        taskRep.deleteByUserId(userId);
        userRep.deleteById(userId);

    }

}
