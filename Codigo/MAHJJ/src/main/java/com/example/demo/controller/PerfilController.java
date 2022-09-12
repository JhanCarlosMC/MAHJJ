package com.example.demo.controller;

import com.example.demo.model.Perfil;

import com.example.demo.model.Usuario;
import com.example.demo.services.PerfilServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class PerfilController {
    @Autowired
    PerfilServices perfilServices;
    @PostMapping("/perfil")
    private  void crearperfil(@RequestBody Perfil perfil){

        perfilServices.crearYactualizarPerfil(perfil);
    }

    // listar  perfiles  controlador
    @GetMapping("/perfil")
    private List<Perfil> verPerfiles(){
        return  perfilServices.mostarPerfil();
    }


    @DeleteMapping("/perfil/{id}")
    private void eliminarPerfil(@PathVariable("id") long id){

        perfilServices.eliminarPerfil(id);
    }

    @PutMapping("/perfil")
    private void editarUsuario(@RequestBody Perfil perfil){
        perfilServices.crearYactualizarPerfil(perfil);
    }
}
