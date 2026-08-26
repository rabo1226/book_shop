package com.green.book_shop.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin")
public class AdminController {

  //대시보드 페이지(관리자 메인 페이지)
  @GetMapping("/")
  public String adminMain(){
    return "admin/dash_board";
  }

  // 도서등록 페이지
  @GetMapping("/book-form")
  public String bookForm(@RequestParam(name="memId") String memId, Model model){
    model.addAttribute("memId", memId);
    return "pages/admin/book_form";
  }


}

