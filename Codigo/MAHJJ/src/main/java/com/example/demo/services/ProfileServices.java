package com.example.demo.services;

import com.example.demo.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.repository.ProfileRepository;

@Service
public class ProfileServices {

    @Autowired
    ProfileRepository repository;
        
    /**
    *  El sistema permite consultar todos los perfils
    *
    * 
    * @return List<Usuario>
    */
    public List<Profile> getAllProfiles(){
        List<Profile> dataList = null;
        try {
            dataList = new ArrayList<>();
            dataList.addAll(repository.findAll());
        } catch (Exception e) {
            System.err.println("ERROR");
        }
        return  dataList;
    }
    
    /**
    * El sistema permite consultar un solo perfil
    *
    * @param id 
    * @return Usuario
    */
    public Profile getProfile(Long id){
        Profile data = null;
        try {
            data = repository.getReferenceById(id);
        } catch (Exception e) {
            System.err.println("ERROR");
        }
        return data;
    }

    /**
    * El sistema permite crear un perfil
    *
    * @param perfil 
    * @return Usuario
    */
    public Profile createProfile(Profile perfil){
        Profile data = null;
        try {
            data = repository.save(perfil);
        } catch (Exception e) {
        }
        return data;
    }
    
    /**
    * El sistema permite editar un perfil
    *
    * @param perfil 
    * @return Usuario
    */
    public Profile editProfile(Profile perfil){
        Profile data = null;
        try {
            data = repository.saveAndFlush(perfil);
        } catch (Exception e) {
        }
        return data;
    }

    /**
    * El sistema permite eliminar un perfil
    *
    * @param id 
    * @return Usuario
    */
    public boolean deleteProfile(Long id){
        Boolean delete = false;
        try {
            repository.deleteById(id);
            delete = true;
        } catch (Exception e) {
        }
        return delete;
    }


}
