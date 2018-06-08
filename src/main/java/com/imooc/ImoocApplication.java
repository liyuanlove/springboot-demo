package com.imooc;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.mapper.provider.base.BaseInsertProvider;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//扫描mybatis mapper包路径
@MapperScan(basePackages = "com.imooc.mapper")
//扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
@ComponentScan(basePackages= {"com.imooc", "org.n3r.idworker"})
//使用tk-mybatis框架插入数据时，需要加此注解
@AutoConfigureAfter(BaseInsertProvider.class)
//开启定时任务
@EnableScheduling
//开启异步调用方法
@EnableAsync
public class ImoocApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImoocApplication.class, args);
    }
}
