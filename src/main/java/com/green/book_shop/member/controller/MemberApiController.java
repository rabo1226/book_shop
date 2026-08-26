package com.green.book_shop.member.controller;

import com.green.book_shop.member.dto.MemberDTO;
import com.green.book_shop.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/member-api")
@RequiredArgsConstructor
//비동기 통신(API) 지원 controller (@Responsbody 사용안해도 괜찮~~~~~) => 동기/비동기 통신 controller 생성!
@RestController
public class MemberApiController {
  private final MemberService memberService;

  //아이디 중복검사
  @GetMapping("/check-id")
  public boolean selectMemId(@RequestParam(name="memId") String memId){
    System.out.println("memId = " + memId);
    boolean result = memberService.isDuplicateId(memId);

    return result;
  }

  //로그인
  @GetMapping("/login")
  public MemberDTO login(MemberDTO memberDTO, HttpServletRequest request){
    //로그인 쿼리 실행
    //조회되면 로그인 가능/ 조회x 로그인x
    MemberDTO loginInfo = memberService.login(memberDTO);

    //로그인 가능한 회원
    if (loginInfo != null){
      //세션에 로그인 정보 저장! (아이디(ID)+권한(ROLE))
      HttpSession session = request.getSession();
      session.setAttribute("loginInfo", loginInfo);
    }
    return loginInfo;
  }

}
