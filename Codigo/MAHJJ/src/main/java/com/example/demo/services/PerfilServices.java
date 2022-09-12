package com.example.demo.services;

import com.example.demo.model.Perfil;
import com.example.demo.model.Usuario;
import com.example.demo.repository.PerfilRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PerfilServices {


    @Autowired
    PerfilRepository perfilRepository;
    public void  crearYactualizarPerfil(Perfil perfil){

        perfilRepository.save(perfil);

    }

    // LISTAR  PERFILES

    public  List<Perfil> mostarPerfil (){
        List<Perfil> perfiles = new ArrayList<Perfil>();
        perfiles.addAll(perfilRepository.findAll());
        return  perfiles;
    }

    public void eliminarPerfil(Long id){

        perfilRepository.deleteById(id);

    }




}
