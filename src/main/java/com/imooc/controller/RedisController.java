package com.imooc.controller;

import com.imooc.common.JsonResult;
import com.imooc.pojo.SysUser;
import com.imooc.pojo.User;
import com.imooc.utils.JsonUtils;
import com.imooc.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 整合redis
 * Created by songyouyu on 2018/6/8
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisUtils redis;


    @RequestMapping("/test")
    public JsonResult test() {
        stringRedisTemplate.opsForValue().set("imooc", "hello-imooc");

        SysUser user = new SysUser();
        user.setId("100111");
        user.setUsername("imooc");
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        stringRedisTemplate.opsForValue().set("json:user", JsonUtils.objectToJson(user));

        SysUser jsonUser = JsonUtils.jsonToPojo(stringRedisTemplate.opsForValue().get("json:user"), SysUser.class);

        return JsonResult.ok(jsonUser);
    }

    @RequestMapping("/getJsonList")
    public JsonResult getJsonList() {

        User user = new User();
        user.setAge(18);
        user.setName("慕课网");
        user.setPassword("123456");
        user.setBirthday(new Date());

        User u1 = new User();
        u1.setAge(19);
        u1.setName("imooc");
        u1.setPassword("123456");
        u1.setBirthday(new Date());

        User u2 = new User();
        u2.setAge(17);
        u2.setName("hello imooc");
        u2.setPassword("123456");
        u2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u1);
        userList.add(u2);

        redis.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);

        String userListJson = redis.get("json:info:userlist");
        List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);

        return JsonResult.ok(userListBorn);
    }

}
