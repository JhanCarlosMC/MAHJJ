package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioServices usuarioServices;

    // Metodos Marieth Perpiñan 
    
    /**
     * Endpoint que permite que: El sistema permite consultar todos los usuarios
     *
     *
     * @return List<Usuario>
     */
    @GetMapping("/usuarios")
    private List<Usuario> getAllUsers() {
        return usuarioServices.getAllUsers();
    }

    /**
     * Endpoint que permite que: El sistema permite consultar un solo usuario
     *
     * @param id
     * @return Usuario
     */
    @GetMapping("/usuario/{id}")
    private Usuario getUser(@PathVariable("id") long id) {
        return usuarioServices.getUser(id);
    }

    /**
     * Endpoint que permite que: El sistema permite crear un usuario
     *
     * @param usuario
     * @return Usuario
     */
    @PostMapping("/usuario")
    private void createUser(@RequestBody Usuario usuario) {
        usuarioServices.createUser(usuario);
    }

    /**
     * Endpoint que permite que: El sistema permite editar un usuario
     *
     * @param usuario
     * @return Usuario
     */
    @PutMapping("/usuario")
    private void editUser(@RequestBody Usuario usuario) {
        usuarioServices.editUser(usuario);
    }

    /**
     * Endpoint que permite que: El sistema permite eliminar un usuario
     *
     * @param id
     * @return Usuario
     */
    @DeleteMapping("/usuario/{id}")
    private void deleteUser(@PathVariable("id") long id) {
        usuarioServices.deleteUser(id);
    }

}
