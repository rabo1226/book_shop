package com.green.book_shop;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
//프로젝트 시작 컨트롤러
public class MainController {
  //시작 페이지를 결정하는 메서드
  @GetMapping("/")
  public String main(){
    return "redirect:/book/list";
  }


}
