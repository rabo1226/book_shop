package com.green.book_shop.admin.controller;

import com.green.book_shop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/admin-api")
@RestController
@RequiredArgsConstructor
public class AdminApiController {
  private final BookService bookService;

  @GetMapping("/check-category-Name")
  public boolean checkCategoryName(@RequestParam(name = "cName") String categoryName){
    //카테고리명 중복확인 메서드 실행
    boolean result = bookService.checkCategoryName(categoryName);

    return result;
  }
}
