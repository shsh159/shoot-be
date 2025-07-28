package com.shoot.be.domain.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
    private Long id;
    private String userId;
    private String userPassword;
    private String userName;
}