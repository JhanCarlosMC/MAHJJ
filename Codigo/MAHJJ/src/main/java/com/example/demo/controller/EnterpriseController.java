package com.example.demo.controller;

import com.example.demo.model.Enterprise;
import com.example.demo.services.EnterpriseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnterpriseController {

    @Autowired
    EnterpriseServices service;
    
    /**
     * Endpoint que permite que: El sistema permite consultar todos los usuarios
     *
     *
     * @return List<Usuario>
     */
    @GetMapping("/enterprises")
    private List<Enterprise> getAllEnterprises() {
        return service.getAllEnterprises();
    }

    /**
     * Endpoint que permite que: El sistema permite consultar un solo usuario
     *
     * @param id
     * @return Usuario
     */
    @GetMapping("/enterprise/{id}")
    private Enterprise getEnterprise(@PathVariable("id") long id) {
        return service.getEnterprise(id);
    }

    /**
     * Endpoint que permite que: El sistema permite crear un usuario
     *
     * @param usuario
     * @return Usuario
     */
    @PostMapping("/enterprise")
    private void createEnterprise(@RequestBody Enterprise usuario) {
        service.createEnterprise(usuario);
    }

    /**
     * Endpoint que permite que: El sistema permite editar un usuario
     *
     * @param usuario
     * @return Usuario
     */
    @PutMapping("/enterprise")
    private void editEnterprise(@RequestBody Enterprise usuario) {
        service.editEnterprise(usuario);
    }

    /**
     * Endpoint que permite que: El sistema permite eliminar un usuario
     *
     * @param id
     * @return Usuario
     */
    @DeleteMapping("/enterprise/{id}")
    private void deleteEnterprise(@PathVariable("id") long id) {
        service.deleteEnterprise(id);
    }

}
