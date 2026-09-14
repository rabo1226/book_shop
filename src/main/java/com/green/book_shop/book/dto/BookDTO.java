package com.green.book_shop.book.dto;

import lombok.Data;

@Data
public class BookDTO {
  private Long bookNo;
  private String bookName;
  private String author;
  private Long bookPrice;
  private Long stock;
  private String bookInfo;
  private Long categoryNo;
}
