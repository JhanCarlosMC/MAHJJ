package com.example.demo.services;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.repository.UserRepository;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;
    
    // Metodos Marieth Perpiñan 
    
    /**
    *  El sistema permite consultar todos los usuarios
    *
    * 
    * @return List<Usuario>
    */
    public List<User> getAllUsers(){
        List<User> users = null;
        try {
            users = new ArrayList<>();
            users.addAll(userRepository.findAll());
        } catch (Exception e) {
            System.err.println("ERROR");
        }
        return  users;
    }
    
    /**
    * El sistema permite consultar un solo usuario
    *
    * @param id 
    * @return Usuario
    */
    public User getUser(Long id){
        User user = null;
        try {
            user = userRepository.getReferenceById(id);
        } catch (Exception e) {
            System.err.println("ERROR");
        }
        return user;
    }

    /**
    * El sistema permite crear un usuario
    *
    * @param usuario 
    * @return Usuario
    */
    public User createUser(User usuario){
        User user = null;
        try {
            user = userRepository.save(usuario);
        } catch (Exception e) {
        }
        return user;
    }
    
    /**
    * El sistema permite editar un usuario
    *
    * @param usuario 
    * @return Usuario
    */
    public User editUser(User usuario){
        User user = null;
        try {
            user = userRepository.saveAndFlush(usuario);
        } catch (Exception e) {
        }
        return user;
    }

    /**
    * El sistema permite eliminar un usuario
    *
    * @param id 
    * @return Usuario
    */
    public boolean deleteUser(Long id){
        Boolean delete = false;
        try {
            userRepository.deleteById(id);
            delete = true;
        } catch (Exception e) {
        }
        return delete;
    }


}
