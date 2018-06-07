package com.imooc.exception;

import com.imooc.common.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by songyouyu on 2018/6/7
 */
@RestControllerAdvice
public class ImoocAjaxExceptionHandler {

    //@ExceptionHandler(value = Exception.class)
    public JsonResult defaultErrorHandler(HttpServletRequest req,
                                                 Exception e) throws Exception {

        e.printStackTrace();
        return JsonResult.errorException(e.getMessage());
    }
}
