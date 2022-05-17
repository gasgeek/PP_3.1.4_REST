package com.example.pp_3_1_4_rest.service;

import com.example.pp_3_1_4_rest.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    User findByEmail(String email);

    List<User> findAll();

    void saveUser(User user);

    void deleteById(Long id);

    void updateUser(User user);
}
