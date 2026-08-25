package com.green.book_shop.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

  //도서 목록 페이지
  @GetMapping("/book/list")
  public String bookList(){
    return "pages/book/book_list";
  }
}
