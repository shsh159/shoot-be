package com.shoot.be.domain.member;

import com.shoot.be.domain.member.dto.LoginRequestDTO;
import com.shoot.be.domain.member.dto.LoginResponseDTO;
import com.shoot.be.domain.member.dto.MemberDTO;
import com.shoot.be.global.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    @Value("${jwt.secret}")
    private String secretKey;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public ResponseDTO<LoginResponseDTO> login(LoginRequestDTO loginRequest) {
        MemberDTO user = memberMapper.findByUserId(loginRequest.getUserId());

        if (user == null) {
            return ResponseDTO.<LoginResponseDTO>builder()
                    .success(false)
                    .message("존재하지 않는 사용자입니다.")
                    .build();
        }

        boolean isPasswordMatch = BCrypt.checkpw(loginRequest.getUserPassword(), user.getUserPassword());
        if (!isPasswordMatch) {
            return ResponseDTO.<LoginResponseDTO>builder()
                    .success(false)
                    .message("비밀번호가 일치하지 않습니다.")
                    .build();
        }

        LoginResponseDTO loginResponse = new LoginResponseDTO(user.getId(), user.getUserId(), user.getUserName());
        return ResponseDTO.<LoginResponseDTO>builder()
                .success(true)
                .message("로그인 성공")
                .data(loginResponse)
                .build();
    }
}
