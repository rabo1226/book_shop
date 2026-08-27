package com.green.book_shop.book.dto;

import lombok.Data;

@Data
public class BookDTO {
  private long bookNo;
  private String bookName;
  private String author;
  private long bookPrice;
  private long stock;
  private String bookInfo;
  private long categoryNo;
}
