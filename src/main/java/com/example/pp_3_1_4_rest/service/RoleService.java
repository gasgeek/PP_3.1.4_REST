package com.example.pp_3_1_4_rest.service;

import com.example.pp_3_1_4_rest.model.Role;

import java.util.HashSet;
import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role getById(int id);

    Role getRoleByName(String name);

    HashSet<Role> getSetOfRoles(String[] roleNames);

    void addRole(Role role);
}
