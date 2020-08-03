package org.example.service.impl;

import org.example.dao.UserDAO;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public User save(User user) throws Exception {
        if (user.getLogin() != null && userDAO.findByLogin(user.getLogin()) != null){
            throw new Exception("user with this login already exists");
        }
        return userDAO.save(user);
    }

    @Override
    public User findById(Integer id) throws Exception {
        return userDAO.findById(id).orElseThrow(() -> new Exception("user not found"));
    }

    @Override
    public User update(User user) throws Exception {
        if (user.getId() == null || userDAO.findById(user.getId()) == null){
            throw new Exception("user id not found");
        }
        return userDAO.save(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public List<User> findAll() throws Exception {
        if (userDAO.findAll().isEmpty()){
            throw new Exception("no users found");
        }
        return userDAO.findAll();
    }

    @Override
    public User findByLogin(String login) throws Exception {
        if (userDAO.findByLogin(login) == null){
            throw new Exception("user with this login was not found");
        }
        return userDAO.findByLogin(login);
    }

    @Override
    public User findByLoginAndPassword(String login, String password) throws Exception {
        if (userDAO.findByLoginAndPassword(login,password) == null){
            throw new Exception("user with this login and password was not found");
        }
        return userDAO.findByLoginAndPassword(login, password);
    }
}
