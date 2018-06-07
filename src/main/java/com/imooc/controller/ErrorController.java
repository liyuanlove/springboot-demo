package com.imooc.controller;

import com.imooc.common.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by songyouyu on 2018/6/7
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/error")
    public String error() {

        int a = 1 / 0;

        return "hello";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxerror() {

        return "thymeleaf/ajaxerror";
    }

    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public JsonResult getAjaxerror() {
        int a = 1 / 0;

        return JsonResult.ok();
    }
}
