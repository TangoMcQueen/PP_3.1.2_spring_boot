package com.ez.spring.dao;

import com.ez.spring.model.User;
import java.util.List;

public interface UserDao {
    public List<User> listUsers();
    public void save (User user);
    public User getUser(int id);
    public void update (User user);
    public void delete(int id);
}