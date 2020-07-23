package com.inossem.electric.common.utils;

import org.apache.http.HttpStatus;

/**
 * @author sunshuai
 * @date 2019-03-27 14:22
 */
public class GlobalException extends RuntimeException {

  private Integer code;

  public GlobalException(int status, String msg) {
    super(msg);
    this.code = status;
  }

  public GlobalException(String msg) {
    super(msg);
    this.code = HttpStatus.SC_INTERNAL_SERVER_ERROR;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }
}
