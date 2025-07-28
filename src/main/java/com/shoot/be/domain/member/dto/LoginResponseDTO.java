package com.shoot.be.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponseDTO {
    private Long id;
    private String userId;
    private String userName;
}
