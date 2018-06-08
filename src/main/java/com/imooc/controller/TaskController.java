package com.imooc.controller;

import com.imooc.tasks.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * 整合异步任务
 * Created by songyouyu on 2018/6/8
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("/test")
    public String test1() throws Exception {

        long start = System.currentTimeMillis();

        Future<Boolean> a = asyncTask.doTask11();
        Future<Boolean> b = asyncTask.doTask22();
        Future<Boolean> c = asyncTask.doTask33();

        while (!a.isDone() || !b.isDone() || !c.isDone()) {
            if (a.isDone() && b.isDone() && c.isDone()) {
                break;
            }
        }

        long end = System.currentTimeMillis();

        String times = "任务全部完成，总耗时：" + (end - start) + "毫秒";
        System.out.println(times);

        return times;
    }

}
