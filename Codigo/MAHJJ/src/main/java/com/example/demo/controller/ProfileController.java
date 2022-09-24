package com.example.demo.controller;

import com.example.demo.model.Profile;
import com.example.demo.services.ProfileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {

    @Autowired
    ProfileServices service;
    
    /**
     * Endpoint que permite que: El sistema permite consultar todos los usuarios
     *
     *
     * @return List<Usuario>
     */
    @GetMapping("/profiles")
    private List<Profile> getAllProfiles() {
        return service.getAllProfiles();
    }

    /**
     * Endpoint que permite que: El sistema permite consultar un solo usuario
     *
     * @param id
     * @return Usuario
     */
    @GetMapping("/profile/{id}")
    private Profile getProfile(@PathVariable("id") long id) {
        return service.getProfile(id);
    }

    /**
     * Endpoint que permite que: El sistema permite crear un usuario
     *
     * @param usuario
     * @return Usuario
     */
    @PostMapping("/profile")
    private void createProfile(@RequestBody Profile usuario) {
        service.createProfile(usuario);
    }

    /**
     * Endpoint que permite que: El sistema permite editar un usuario
     *
     * @param usuario
     * @return Usuario
     */
    @PutMapping("/profile")
    private void editProfile(@RequestBody Profile usuario) {
        service.editProfile(usuario);
    }

    /**
     * Endpoint que permite que: El sistema permite eliminar un usuario
     *
     * @param id
     * @return Usuario
     */
    @DeleteMapping("/profile/{id}")
    private void deleteProfile(@PathVariable("id") long id) {
        service.deleteProfile(id);
    }

}
