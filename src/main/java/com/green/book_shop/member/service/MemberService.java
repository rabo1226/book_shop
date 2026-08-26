package com.green.book_shop.member.service;

import com.green.book_shop.member.dto.MemberDTO;
import com.green.book_shop.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
  private final MemberMapper memberMapper;

  //회원가입 기능
  public void insertMember(MemberDTO memberDTO){
    memberMapper.insertMember(memberDTO);
  }

  //id중복검사 기능
  public boolean isDuplicateId(String memId){
    String result = memberMapper.isDuplicateId(memId);
    return result != null;
  }

  //로그인 가능여부 확인!
  public MemberDTO checkLogin(MemberDTO memberDTO){
    MemberDTO loginInfo = memberMapper.checkLogin(memberDTO);
    return loginInfo;
  }


}
