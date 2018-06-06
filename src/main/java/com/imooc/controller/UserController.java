package com.imooc.controller;

import com.imooc.common.JsonResult;
import com.imooc.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by songyouyu on 2018/6/6
 */
//@Controller
@RestController   // @RestController = @Controller + @ResponseBody
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
    //@ResponseBody
    public User getUser() {
        User user = new User();
        user.setName("imooc");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPassword("123456");
        user.setDesc("");

        return user;
    }

    @RequestMapping("/getUserJson")
    //@ResponseBody
    public JsonResult getUserJson() {
        User user = new User();
        user.setName("imooc");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPassword("123456");
        user.setDesc(null);

        return JsonResult.ok(user);
    }


}
