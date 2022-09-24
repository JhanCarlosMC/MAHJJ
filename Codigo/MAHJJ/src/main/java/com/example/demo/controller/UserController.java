package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServices service;
    
    /**
     * Endpoint que permite que: El sistema permite consultar todos los usuarios
     *
     *
     * @return List<Usuario>
     */
    @GetMapping("/users")
    private List<User> getAllUsers() {
        return service.getAllUsers();
    }

    /**
     * Endpoint que permite que: El sistema permite consultar un solo usuario
     *
     * @param id
     * @return Usuario
     */
    @GetMapping("/user/{id}")
    private User getUser(@PathVariable("id") long id) {
        return service.getUser(id);
    }

    /**
     * Endpoint que permite que: El sistema permite crear un usuario
     *
     * @param usuario
     * @return Usuario
     */
    @PostMapping("/user")
    private void createUser(@RequestBody User usuario) {
        service.createUser(usuario);
    }

    /**
     * Endpoint que permite que: El sistema permite editar un usuario
     *
     * @param usuario
     * @return Usuario
     */
    @PutMapping("/user")
    private void editUser(@RequestBody User usuario) {
        service.editUser(usuario);
    }

    /**
     * Endpoint que permite que: El sistema permite eliminar un usuario
     *
     * @param id
     * @return Usuario
     */
    @DeleteMapping("/user/{id}")
    private void deleteUser(@PathVariable("id") long id) {
        service.deleteUser(id);
    }

}
