package com.imooc.exception;

import com.imooc.common.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 * Created by songyouyu on 2018/6/7
 */
@ControllerAdvice
public class ImoocExceptionHandler {

    public static final String IMOOC_ERROR_VIEW = "error";

	//@ExceptionHandler(value = Exception.class)
//    public Object errorHandler(HttpServletRequest request,
//                               HttpServletResponse response, Exception e) throws Exception {
//
//    	e.printStackTrace();
//
//		ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", request.getRequestURL());
//        mav.setViewName(IMOOC_ERROR_VIEW);
//        return mav;
//    }

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest,
                               HttpServletResponse response, Exception e) throws Exception {

        e.printStackTrace();

        if (isAjax(reqest)) {
            return JsonResult.errorException(e.getMessage());
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(IMOOC_ERROR_VIEW);
            return mav;
        }
    }

    /**
     * @Description: 判断是否是ajax请求
     */
    public static boolean isAjax(HttpServletRequest httpRequest){
        return  (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals( httpRequest.getHeader("X-Requested-With").toString()) );
    }

}
