package com.green.book_shop.book.mapper;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
  //도서 카테고리 조회
  List<BookCategoryDTO> selectCategory();

  //도서 등록
  void regBook(BookDTO bookDTO);
}
