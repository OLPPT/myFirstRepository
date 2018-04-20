package com.example.demo.service;

import com.example.demo.pojo.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by OL-PC on 2018/04/19.
 */
public interface UserService {
    public void saveUser(SysUser user) throws Exception;

    public void updateUser(SysUser user);

    public void deleteUser(Integer userId);

    public SysUser queryUserById(Integer userId);

    public List<SysUser> queryUserList(SysUser user);

    public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize);

    public void selectByIdPro(SysUser sysUser);

    public List<SysUser> selectPagePro(Map<String,Object> params);
//    public SysUser queryUserByIdCustom(String userId);
//
//    public void saveUserTransactional(SysUser user);
}
