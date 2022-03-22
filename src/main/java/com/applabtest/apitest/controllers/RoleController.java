package com.applabtest.apitest.controllers;

import com.applabtest.apitest.models.RolesEntity;
import com.applabtest.apitest.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @CrossOrigin
    @GetMapping(path = "roles")
    public ArrayList<RolesEntity> findAll(){
        return roleService.findAllRoles();
    }
}
