package com.imooc.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 读取配置文件中的信息
 * Created by songyouyu on 2018/6/7
 */
@Configuration
@ConfigurationProperties(prefix="com.imooc.opensource")
@PropertySource(value="classpath:resource.properties")
@Data
public class Resource {

    private String name;

    private String website;

    private String language;


}
