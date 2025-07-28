package com.shoot.be.domain.member;

import com.shoot.be.domain.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
    MemberDTO findByUserId(@Param("userId") String userId);
}
