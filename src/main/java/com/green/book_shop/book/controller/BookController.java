package com.green.book_shop.book.controller;

import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/book")
@RequiredArgsConstructor
@Controller
public class BookController {
  private final BookService bookService;

  //도서 목록 페이지
  @GetMapping("/list")
  public String bookList(){
    return "pages/book/book_list";
  }


  @GetMapping("book-category")
  public String bookCategory(){
    return "pages/admin/book-category";
  }


}
