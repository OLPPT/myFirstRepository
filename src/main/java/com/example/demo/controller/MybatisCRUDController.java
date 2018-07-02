package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.pojo.SysUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by OL-PC on 2018/04/19.
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisCRUDController {

    @Autowired
    private UserService userService;
    @RequestMapping("/saveUser")
    public SysUser saveUser() throws Exception{
        SysUser sysUser = new SysUser();
        sysUser.setAge(12);
        sysUser.setCreatetime(new Date());
        sysUser.setSex("1");
        sysUser.setUsername("mooc");
        sysUser.setDes("hello");
        userService.saveUser(sysUser);
        return sysUser;
    }
    @RequestMapping("/updateUser")
    public SysUser updateUser() throws Exception{
        SysUser sysUser = new SysUser();
        sysUser.setId(1);
        sysUser.setUsername("updateName");
        sysUser.setDes("updateDes");
        userService.updateUser(sysUser);
        return sysUser;
    }
    @RequestMapping("/userListPaged/{page}")
    public List<SysUser> userListPaged(@PathVariable Integer page) throws Exception{
        if (page == null){
            page = 1;
        }
        int pageSize = 5;
        SysUser sysUser = new SysUser();
        return userService.queryUserListPaged(sysUser,page,pageSize);
    }
    @RequestMapping("/selectOne")
    public SysUser selectOne() throws Exception{
        SysUser sysUser = new SysUser();
        sysUser.setId(1);
        userService.selectByIdPro(sysUser);
        System.out.println("用户名:"+sysUser.getUsername());
        return sysUser;
    }
    @RequestMapping("/selectPage/{username}")
    public List<SysUser> selectPage(@PathVariable String username) throws Exception{
        Map<String,Object> params = new HashMap<>();
        params.entrySet();
        params.put("username",username);
        params.put("offset",0);
        params.put("limit",5);
        List<SysUser> userList = userService.selectPagePro(params);
        System.out.println(params.get("total"));
        return userList;
    }
}
