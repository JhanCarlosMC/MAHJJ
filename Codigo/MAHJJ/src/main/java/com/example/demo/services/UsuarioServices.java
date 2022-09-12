package com.example.demo.services;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServices {

    @Autowired
    UsuarioRepository usuarioRepository;


    public void  crearYactualizarUsuario(Usuario   usuario){
    usuarioRepository.save(usuario);
    }


    public List<Usuario> verUsuario(){

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.addAll(usuarioRepository.findAll());
        return  usuarios;
    }

    public void  eliminarUsuario(Long id){

        usuarioRepository.deleteById(id);

    }




}
