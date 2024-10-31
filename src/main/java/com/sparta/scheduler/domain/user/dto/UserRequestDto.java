package com.sparta.scheduler.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "올바른 이름이 아닙니다, 입력하지 않았거나 빈 공간이 있는지 확인하세요")
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",
            message = "올바른 이메일 형식이 아닙니다. ")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,20}$",
            message = "비밀번호는 [8 ~ 20]글자 이내이며, [영문 + 숫자]을 포함해야 합니다")
    private String password;
}
