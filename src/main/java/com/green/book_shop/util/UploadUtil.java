package com.green.book_shop.util;

import com.green.book_shop.book.dto.BookImgDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component  //객체 생성 어노테이션
//업로드 관련 기능을 가진 클래스
public class UploadUtil {
  //application.yaml에 선언된 file.upload.dir 변수의 값을 uploadPath에 주입
  @Value("${file.upload.dir}")
  private String uploadPath; //업로드 디렉토리(경로)

  //단일 파일 업로드 메서드  / static -> 클래스명.메서드명
  public BookImgDTO fileUpload(MultipartFile mainImgFile){
    //전달받은 파일의 원본 파일명
    String originFileName = mainImgFile.getOriginalFilename();
    System.out.println(originFileName);

    //서버에 파일 업로드
    //첨부할 파일명 생성
    String uuid = UUID.randomUUID().toString();  //랜덤한 문자열 생성

    //첨부된 파일에서 확장자만 추출
    //원본 파일명에서 .의 위치 추출
    int dotIndex = originFileName.lastIndexOf(".");
    String extension = originFileName.substring(dotIndex);

    //업로드파일명 지정 ex)D://01-STUDY/dev/upload/{mainIngFile}
    //String uploadFile = uploadPath + mainImgFile.getOriginalFilename();
    //업로드파일명 지정 ex)D://01-STUDY/dev/upload/랜덤한 문자열
    String uploadFile = uploadPath + uuid + extension;
    //정해진 경로에 파일을 생성(껍데기 파일)
    File file = new File(uploadFile);

    try {
      //업로드하기 위해 가져온 실제 이미지파일을 위에서 만든 껍데기 파일로 변환
      mainImgFile.transferTo(file);
      //업로등 성공 시 리턴할 데이터 생성
      BookImgDTO bookImgDTO = new BookImgDTO();
      bookImgDTO.setOriginFileName(originFileName);
      bookImgDTO.setAttachedFileName(uuid + extension);
      return  bookImgDTO;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

}
