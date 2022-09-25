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
    UserRepository repository;
        
    /**
    *  El sistema permite consultar todos los usuarios
    *
    * 
    * @return List<User>
    */
    public List<User> getAllUsers(){
        List<User> dataList = null;
        try {
            dataList = new ArrayList<>();
            dataList.addAll(repository.findAll());
        } catch (Exception e) {
            System.err.println("ERROR");
        }
        return  dataList;
    }
    
    /**
    * El sistema permite consultar un solo usuario
    *
    * @param id 
    * @return Usuario
    */
    public User getUser(Long id){
        User data = null;
        try {
            data = repository.getReferenceById(id);
        } catch (Exception e) {
            System.err.println("ERROR");
        }
        return data;
    }

    /**
    * El sistema permite crear un usuario
    *
    * @param usuario 
    * @return Usuario
    */
    public User createUser(User usuario){
        User data = null;
        try {
            data = repository.save(usuario);
        } catch (Exception e) {
        }
        return data;
    }
    
    /**
    * El sistema permite editar un usuario
    *
    * @param usuario 
    * @return Usuario
    */
    public User editUser(User usuario){
        User data = null;
        try {
            data = repository.saveAndFlush(usuario);
        } catch (Exception e) {
        }
        return data;
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
            repository.deleteById(id);
            delete = true;
        } catch (Exception e) {
        }
        return delete;
    }


}
