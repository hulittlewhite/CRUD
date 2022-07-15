package com.jieshi.crud.service.impl;

import com.jieshi.crud.dao.UserdDao;
import com.jieshi.crud.pojo.User;
import com.jieshi.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserdDao userdDao;

    @Override
    public List<User> findAll() {
        return userdDao.findAll();
    }

    @Override
    public int save(User user) {
        return userdDao.save(user);
    }

    @Override
    public int delete(int id) {
        return userdDao.delete(id);
    }

    @Override
    public User get(int id) {
        return userdDao.get(id);
    }

    @Override
    public int updateById(User user) {
        return userdDao.updateById(user);
    }

}
