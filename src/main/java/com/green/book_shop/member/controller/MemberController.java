package com.green.book_shop.member.controller;

import com.green.book_shop.member.dto.MemberDTO;
import com.green.book_shop.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class MemberController {
  private final MemberService memberService;

  //회원가입 버튼 누르면 정보를 받는다!
  @PostMapping("/member/join")
  public String insertMember(MemberDTO memberDTO){
    //전달받은 데이터
    memberDTO.setMemTel();
    System.out.println(memberDTO.getMemTel());
    System.out.println("\nmemDTO" + memberDTO);

    memberService.insertMember(memberDTO);
    return "redirect:/";
  }

  //아이디 중복검사
  @ResponseBody
  @GetMapping ("/member/check-id")
  public boolean selectMemId(@RequestParam(name="memId") String memId){
    System.out.println("memId = " + memId);
    boolean result = memberService.isDuplicateId(memId);

    return result;
  }



}
