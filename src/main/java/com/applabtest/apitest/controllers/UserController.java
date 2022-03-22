package com.applabtest.apitest.controllers;

import com.applabtest.apitest.models.UserEntity;
import com.applabtest.apitest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Salvador Alcala
 * UserController es la clase encargada de controllar los EndPoints para los Usuarios
 */

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Este metodo retorna una lista con todos los usuarios
     * @return List of UserEntity
     */
    @CrossOrigin
    @GetMapping(path = "users")
    public ArrayList<UserEntity> findAll(){
        return userService.findAllUsers();
    }

    /**
     * Este metodo retorna un usuario, que es buscado por userId
     * @param userId
     * @return Objet of UserEntity
     */
    @CrossOrigin
    @GetMapping(path = "user/{userId}")
    public Optional<UserEntity> findById(@PathVariable("userId") Long userId){
        return userService.findByUserId(userId);
    }

    /**
     * Este metodo retorna una lista de usuarios filtrados por su status
     * @param status
     * @return List of UserEntity
     */
    @CrossOrigin
    @GetMapping(path = "user/filter/status/{status}")
    public List<UserEntity> findByStatus(@PathVariable("status") Boolean status) {
        return userService.findUsersByStatus(status);
    }

    /**
     * Este metodo retorna una lista de usuarios filtrados por rol
     * @param roleName
     * @return List of UserEntity
     */
    @CrossOrigin
    @GetMapping(path = "user/filter/role/{roleName}")
    public List<UserEntity> findByRole(@PathVariable("roleName") String roleName) {
        return userService.findUsersByRoleName(roleName);
    }

    /**
     * Este metodo retorna una lista de usuarios filtrados por rol y status
     * @param status
     * @param roleName
     * @return List of UserEntity
     */
    @CrossOrigin
    @GetMapping(path = "user/filter/{status}/{roleName}")
    public List<UserEntity> findByRoleAndAndStatus(@PathVariable("status") Boolean status,
                                                   @PathVariable("roleName") String roleName) {
        return userService.findByRoleAndAndStatus(status, roleName);
    }

    /**
     * Este metodo guarda o modifica un usuario
     * @param user
     */
    @CrossOrigin
    @PostMapping(path = "user")
    public void saveUser(@RequestBody UserEntity user){
        userService.saveUser(user);
    }

    /**
     * Este metodo borra un usuario
     * @param user
     */
    @CrossOrigin
    @DeleteMapping(path = "user")
    public void deleteUser(@RequestBody UserEntity user){
        userService.deleteUser(user);
    }
}
