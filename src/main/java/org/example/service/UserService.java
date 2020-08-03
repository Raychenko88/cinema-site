package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {
    User save(User user) throws Exception;
    User findById(Integer id) throws Exception;
    User update(User user) throws Exception;
    void delete(User user);
    List<User> findAll() throws Exception;
    User findByLogin(String login) throws Exception;
    User findByLoginAndPassword(String login, String password) throws Exception;
}
