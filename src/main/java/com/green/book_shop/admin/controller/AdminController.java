package com.green.book_shop.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

  //대시보드 페이지(관리자 메인 페이지)
  @GetMapping("/admin")
  public String adminMain(){
    return "admin/dash_board";
  }


}
