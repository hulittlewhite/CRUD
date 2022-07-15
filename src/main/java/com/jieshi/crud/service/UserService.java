package com.jieshi.crud.service;

import com.jieshi.crud.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 查询全部数据
     */
    public List<User> findAll();

    /**
     * 新增数据
     */
    public int save(User user);

    /**
     * 删除数据
     */
    public int delete(int id);

    /**
     * 根据ID查找
     */
    public User get(int id);

    /**
     * 更新数据
     */
    public int updateById(User user);

}
