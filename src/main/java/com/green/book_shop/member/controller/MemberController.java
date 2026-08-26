package com.green.book_shop.member.controller;

import com.green.book_shop.member.dto.MemberDTO;
import com.green.book_shop.member.service.MemberService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    if (memberDTO.getMemId().equals("admin")){
      memberDTO.setMemRole("ADMIN");
      memberService.insertMember(memberDTO);
    }
    else {
      memberService.insertMember(memberDTO);
    }
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

  //로그인 가능여부 확인!(동기로 실행!)데이터 null로그인x
  @PostMapping("/member/login")
  public String login(MemberDTO memberDTO, HttpServletRequest request, Model model){
    MemberDTO loginInfo = memberService.checkLogin(memberDTO);
    System.out.println("\nmemId = " + loginInfo);
    if (loginInfo != null){
      HttpSession session = request.getSession();
      session.setAttribute("loginInfo", loginInfo);
      if (loginInfo.getMemRole().equals("ADMIN")){
        model.addAttribute("loginInfo", loginInfo);
        return "/admin/dash_board";
      }
      else {
        model.addAttribute("loginInfo", loginInfo);
        return "redirect:/book/list";
      }
    }
    else {
      return "redirect:/book/list";
    }
  }



}
