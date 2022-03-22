package com.applabtest.apitest.services;

import com.applabtest.apitest.models.RolesEntity;
import com.applabtest.apitest.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public ArrayList<RolesEntity> findAllRoles(){
        return (ArrayList<RolesEntity>) roleRepository.findAll();
    }
}
