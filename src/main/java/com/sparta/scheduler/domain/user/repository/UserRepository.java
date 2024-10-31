package com.sparta.scheduler.domain.user.repository;

import com.sparta.scheduler.domain.common.exception.ResponseCode;
import com.sparta.scheduler.domain.common.exception.ResponseException;
import com.sparta.scheduler.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    default User findByUser(Long id) {
        return findById(id).orElseThrow(()
                -> new ResponseException(ResponseCode.BAD_REQUEST,"등록되지 않는 회원입니다"));
    }
}