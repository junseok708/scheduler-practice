package com.sparta.scheduler.domain.user.entity;

import com.sparta.scheduler.domain.common.timestamp.Timestamped;
import com.sparta.scheduler.domain.task.entity.Task;
import com.sparta.scheduler.domain.user.dto.UserRequestDto;
import com.sparta.scheduler.domain.user.dto.UserResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @ManyToMany(mappedBy = "users")
    private List<Task> tasks = new ArrayList<>();


    public void init(UserRequestDto userRequestDto) {
        this.name = userRequestDto.getName();
        this.email = userRequestDto.getEmail();
        this.password = userRequestDto.getPassword();
    }


    public UserResponseDto to() {
        return new UserResponseDto(
                id,
                name,
                email,
                password,
                getCreatedAt(),
                getUpdatedAt()
        );
    }

    public void updateDate(UserRequestDto req) {
        this.name = req.getName();
        this.email = req.getEmail();
        this.password = req.getPassword();
    }
}
