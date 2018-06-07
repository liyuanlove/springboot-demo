package com.imooc.controller;

import com.imooc.common.JsonResult;
import com.imooc.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by songyouyu on 2018/6/7
 */
@RestController
public class HelloController {

    @Autowired
    private Resource resource;

    @RequestMapping("/hello")
    public Object hello() {
        return "hello";
    }

    @RequestMapping("/getResource")
    private JsonResult getResource() {
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);

        return JsonResult.ok(bean);
    }
}
