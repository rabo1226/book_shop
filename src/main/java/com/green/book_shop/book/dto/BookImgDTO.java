package com.green.book_shop.book.dto;

import lombok.Data;

@Data
public class BookImgDTO {
  private Long imgNo;
  private String originFileName;
  private String attachedFileName;
  private String isMain;
  private Long bookNo;
}
