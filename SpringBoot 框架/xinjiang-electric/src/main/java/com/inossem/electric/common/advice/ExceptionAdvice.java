package com.inossem.electric.common.advice;

import com.inossem.electric.common.utils.GlobalException;
import com.inossem.electric.common.utils.Result;
import com.inossem.electric.common.utils.ResultUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunshuai
 * @date 2019-03-27 14:22
 */
@org.springframework.web.bind.annotation.ControllerAdvice(basePackages = {
    "com.inossem.electric.modules.*.controller.*"}, annotations = {
    Controller.class, RestController.class})
public class ExceptionAdvice {

  private Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

  @ExceptionHandler({GlobalException.class, Exception.class})
  @ResponseBody
  public ResponseEntity handle(Exception e) {
    logger.error(ExceptionUtils.getStackTrace(e));
    Result result;
    if (e instanceof GlobalException) {
      GlobalException globalException = (GlobalException) e;
      result = ResultUtil.getError(globalException.getCode(), globalException.getMessage());
    } else if (e instanceof MethodArgumentNotValidException) {
      MethodArgumentNotValidException methodArgumentNotValidException =(MethodArgumentNotValidException) e;
      result = ResultUtil.getError(HttpStatus.SC_BAD_REQUEST,
          methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage());
    } else {
      result = ResultUtil.getError(HttpStatus.SC_INTERNAL_SERVER_ERROR, e.getMessage());
    }
    logger.error(result.getMsg());
    return new ResponseEntity<>(result, org.springframework.http.HttpStatus.OK);
  }

}
