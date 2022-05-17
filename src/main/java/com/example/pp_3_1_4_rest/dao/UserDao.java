package com.example.pp_3_1_4_rest.dao;

import com.example.pp_3_1_4_rest.model.User;

import java.util.List;

public interface UserDao {

    void updateUser(User user);

    List<User> findAll();

    User getById(Long id);

    User getByEmail(String email);

    void save(User user);

    void deleteById(Long id);
}