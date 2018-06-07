package com.imooc.mapper;

import com.imooc.pojo.SysUser;

import java.util.List;

/**
 * Created by songyouyu on 2018/6/7
 */
public interface SysUserMapperCustom {

    List<SysUser> queryUserSimplyInfoById(String id);

}
