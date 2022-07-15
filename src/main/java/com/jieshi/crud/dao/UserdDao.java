package com.jieshi.crud.dao;

import com.jieshi.crud.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserdDao {

    /**
     * 查询全部数据
     */
    @Select("select * from user")
     public List<User> findAll();

    /**
     * 新增数据
     */
    @Insert("insert into user (username, password) values (#{username}, #{password})")
    public int save(User user);

    /**
     * 删除数据
     */
    @Delete("delete from user where id =#{id}")
    public int delete(int id);

    /**
     * 根据ID查找
     */
    @Select("select * from user where id =#{id}")
    public User get(int id);

    /**
     * 根据ID更新数据
     */
    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    public int updateById(User user);

}
