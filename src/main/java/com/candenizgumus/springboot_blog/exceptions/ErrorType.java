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
  PASSWORDS_ARE_NOT_SAME(5003,"Sifreler ayni degil", HttpStatus.NOT_FOUND),
  EMAIL_TAKEN(5004,"Email daha önce alınmis", HttpStatus.NOT_FOUND);


  private Integer code;
  private String message;
  private HttpStatus status;
}
