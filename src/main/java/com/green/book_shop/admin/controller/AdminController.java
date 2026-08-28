package com.green.book_shop.admin.controller;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
  private final BookService bookService;

  //대시보드 페이지(관리자 메인 페이지)
  @GetMapping("/")
  public String adminMain(HttpServletRequest request){
    HttpSession session = request.getSession();
    session.getAttribute("loginInfo");
    System.out.println("출력자료 : " + session.getAttribute("loginInfo"));
    return "admin/dash_board";
  }

  //도서 등록 페이지로 이동 (카테고리 목록 조회 + html 전달)
  @GetMapping("/book-form")
  public String bookForm(Model model){
    model.addAttribute("categoryList", bookService.selectCategory());
    //System.out.println( bookService.selectCategory());
    return "pages/admin/book_form";
  }

}

