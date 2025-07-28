package com.shoot.be.domain.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
    private String userId;
    private String userPassword;
}
