package com.candenizgumus.springboot_blog.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType
{
  CATEGORY_NOT_FOUND(5001,"Böyle bir Category bulunamadı", HttpStatus.NOT_FOUND),
  USER_NOT_FOUND(5002,"Böyle bir User bulunamadı", HttpStatus.NOT_FOUND),
  POST_NOT_FOUND(5003,"Böyle bir post bulunamadı", HttpStatus.NOT_FOUND),
  POST_ALREADY_LIKED(5004,"Bu post bu kullanici tarafından begenilmiş.", HttpStatus.NOT_FOUND),
  EMAIL_TAKEN(5005,"Email daha önce alınmis", HttpStatus.NOT_FOUND);


  private Integer code;
  private String message;
  private HttpStatus status;
}
