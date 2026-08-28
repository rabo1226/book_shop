package com.green.book_shop.admin.controller;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
  private final BookService bookService;

  //대시보드 페이지(관리자 메인 페이지)
  @GetMapping("")
  public String adminMain(HttpServletRequest request){
    HttpSession session = request.getSession();
    session.getAttribute("loginInfo");
    System.out.println("출력자료 : " + session.getAttribute("loginInfo"));
    return "pages/admin/dash_board";
  }

  //도서 등록 페이지로 이동 (카테고리 목록 조회 + html 전달)
  @GetMapping("/book-form")
  public String bookForm(Model model){
    model.addAttribute("categoryList", bookService.selectCategory());
    //System.out.println( bookService.selectCategory());
    return "pages/admin/book_form";
  }

  //등록버튼을 누르면 도서 정보를 가져와서 등록
  @PostMapping("/reg-book")
  public String regBook(BookDTO bookDTO){
    System.out.println("\n입력된 도서 : " + bookDTO);
    //도서 등록 쿼리 실행
    bookService.regBook(bookDTO);
    //도서 등록 페이지로 이동
    return "redirect:/admin/book-form";
  }

  //카테고리 등록 버튼 누르면 카테고리 정보 등록 및 등록페이지 실행
  @PostMapping("/reg-category")
  public String insertCategory(BookCategoryDTO bookCategoryDTO){
    System.out.println(bookCategoryDTO);
    bookService.insertCategory(bookCategoryDTO);
    return "redirect:/admin/book-form";
  }

}

