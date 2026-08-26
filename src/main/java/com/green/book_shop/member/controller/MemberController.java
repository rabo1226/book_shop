package com.green.book_shop.member.controller;

import com.green.book_shop.member.dto.MemberDTO;
import com.green.book_shop.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController("/member")
@RequiredArgsConstructor
@Controller
public class MemberController {
  private final MemberService memberService;

  //회원가입 버튼 누르면 정보를 받는다!
  @PostMapping("/join")
  public String insertMember(MemberDTO memberDTO){
    //전달받은 데이터
    memberDTO.setMemTel();
    System.out.println(memberDTO.getMemTel());
    System.out.println("\nmemDTO" + memberDTO);

    memberService.insertMember(memberDTO);
    return "redirect:/";
  }

}
