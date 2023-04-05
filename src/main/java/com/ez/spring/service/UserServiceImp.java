package com.ez.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ez.spring.dao.UserDao;
import com.ez.spring.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserDao userDao;
    @Autowired
    public UserServiceImp (UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }
    @Override
    @Transactional(readOnly = true)
    public User getUser(int id) {
        return userDao.getUser(id);
    }
    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);
    }
    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
}