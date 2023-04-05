package com.ez.spring.dao;

import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ez.spring.model.User;
import jakarta.persistence.EntityManager;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private EntityManager entityManager;
    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
