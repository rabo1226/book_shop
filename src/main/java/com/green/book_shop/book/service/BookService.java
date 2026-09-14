package com.green.book_shop.book.service;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.dto.BookImgDTO;
import com.green.book_shop.book.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

  //이 기능은 도서 기본 정보 등록 + 이미지 정보 등록이라는 두 쿼리로 이루어져있다.
  //두 쿼리 중 하나라도 실패하면 도서 등록은 실패
  //두 쿼리 중 하나라도 실패했다면 성공한 쿼리는  rollback 시켜야 함.
  //이처럼, 다수의 쿼리를 하나로 묶어, 하나라도 실패하면 rollback,
  //포함 된 모든 쿼리가 성공해서 기능 성공으로 간주하는 것을 Transection 이라 한다.
  @Transactional(rollbackFor = Exception.class)
  public void regBook(BookDTO bookDTO, BookImgDTO bookImgDTO){
    //도서 기본 정보 등록
    bookMapper.regBook(bookDTO);
    //도서 이미지 정보 등록
    bookMapper.insertBookImg(bookImgDTO);
  }

  //카테고리 중복 확인 기능 (중복 return true)
  public boolean checkCategoryName(String categoryName){
    String cateName = bookMapper.cName(categoryName);
    return cateName != null;
  }

  //카테고리 등록 기능
  public void insertCategory(BookCategoryDTO bookCategoryDTO){
    bookMapper.insertCategory(bookCategoryDTO);
  }



}
