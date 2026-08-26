package com.green.book_shop.member.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberDTO {
  private String memId;
  private String memPw;
  private String memName;
  private String memTel;
  private String memAddr;
  private String addrDetail;
  private String gender;
  private String memRole;
  private String status;
  private LocalDate joinDate;

  //회원가입 시 전달되는 연락처 데이터 변수(임시)
  private String memTel1;
  private String memTel2;
  private String memTel3;

  //연락처 데이터를 포멧에 맞게 변경
  public void setMemTel(){
    memTel = memTel1 + "-" +  memTel2 +  "-"  + memTel3;
  }

}
