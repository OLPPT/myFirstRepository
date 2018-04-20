package com.example.demo.mapper;

import com.example.demo.pojo.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by OL-PC on 2018/04/19.
 */
public interface ProcedureMapper {
    void selectById(SysUser sysUser);
    List<SysUser> selectPage(Map<String,Object> params);
}
