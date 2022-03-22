package com.applabtest.apitest.services;

import com.applabtest.apitest.models.UserEntity;
import com.applabtest.apitest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @author Salvador Alcala
 * UserService es la clase donde se encuentra la logia y funcionalidad para los usuarios
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * Este metodo retorna una lista con todos los usuarios
     * @return List of UserEntity
     */
    public ArrayList<UserEntity> findAllUsers(){
        return (ArrayList<UserEntity>) userRepository.findAll();
    }

    /**
     * Este metodo retorna un usuario, que es buscado por userId
     * @param userId
     * @return List of UserEntity
     */
    public Optional<UserEntity> findByUserId(Long userId){
        return userRepository.findById(userId);
    }

    /**
     * Este metodo retorna una lista de usuarios filtrados por su status
     * @param status
     * @return List of UserEntity
     */
    public List<UserEntity> findUsersByStatus(Boolean status){
        return userRepository.findUsersByStatus(status);
    }

    /**
     * Este metodo retorna una lista de usuarios filtrados por rol
     * @param roleName
     * @return List of UserEntity
     */
    public List<UserEntity> findUsersByRoleName(String roleName){
        return userRepository.findUsersByRoleName(roleName);
    }

    /**
     * Este metodo retorna una lista de usuarios filtrados por rol y status
     * @param status
     * @param roleName
     * @return List of UserEntity
     */
    public List<UserEntity> findByRoleAndAndStatus(Boolean status, String roleName){
        return userRepository.findByRoleAndAndStatus(status,roleName);
    }

    /**
     * Este metodo guarda o modifica un usuario
     * @param user
     */
    public void saveUser(UserEntity user){
        userRepository.save(user);
    }

    /**
     * Este metodo borra un usuario
     * @param user
     */
    public void deleteUser(UserEntity user){
        userRepository.delete(user);
    }
}
