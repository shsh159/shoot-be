package com.shoot.be.domain.member;

import com.shoot.be.domain.member.dto.LoginRequestDTO;
import com.shoot.be.domain.member.dto.LoginResponseDTO;
import com.shoot.be.global.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<LoginResponseDTO>> login(@RequestBody LoginRequestDTO loginRequest) {
        ResponseDTO<LoginResponseDTO> response = memberService.login(loginRequest);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body(response);
        }
    }
}
