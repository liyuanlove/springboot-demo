package com.imooc.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by songyouyu on 2018/6/7
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {



}
