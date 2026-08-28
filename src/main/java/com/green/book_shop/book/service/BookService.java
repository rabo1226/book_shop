package com.green.book_shop.book.service;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {
  private final BookMapper bookMapper;

  //도서카테고리 목록 리턴
  public List<BookCategoryDTO> selectCategory(){
    return bookMapper.selectCategory();
  }

  //도서 등록 기능
  public void regBook(BookDTO bookDTO){
    bookMapper.regBook(bookDTO);
  }

  //카테고리 등록 기능
  public void insertCategory(BookCategoryDTO bookCategoryDTO){
    bookMapper.insertCategory(bookCategoryDTO);
  }



}
