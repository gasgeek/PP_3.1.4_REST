package com.example.pp_3_1_4_rest.dao;

import com.example.pp_3_1_4_rest.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r ", Role.class).getResultList();
    }

    @Override
    public Role getRoleByName(String name) {
        return entityManager.createQuery(
                "SELECT r from Role r where r.role=:name", Role.class
        ).setParameter("name", name).getSingleResult();
    }

    @Override
    public HashSet<Role> getSetOfRoles(String[] roleNames) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roleNames) {
            roleSet.add(getRoleByName(role));
        }
        return (HashSet<Role>) roleSet;
    }

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void edit(Role role) {
        entityManager.merge(role);
    }

    @Override
    public Role getById(int id) {
        return entityManager.find(Role.class, id);
    }
}