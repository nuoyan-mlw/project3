package com.crazycode.mapper;

import com.crazycode.pojo.Member;
import org.springframework.stereotype.Component;

@Component
public interface MemberMapper {
    //查找Member
    public Member queryMemberById()throws Exception;
}
