package com.green.book_shop.member.mapper;

import com.green.book_shop.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
  //회원가입 쿼리 실행
  void insertMember(MemberDTO memberDTO);

  //id중복검사 쿼리 실행
  String isDuplicateId(String memId);
}
