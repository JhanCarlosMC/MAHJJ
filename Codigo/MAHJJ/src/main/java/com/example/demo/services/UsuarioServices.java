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


    // Metodos Marieth Perpiñan 
    
    /**
    *  El sistema permite consultar todos los usuarios
    *
    * 
    * @return List<Usuario>
    */
    public List<Usuario> getAllUsers(){
        List<Usuario> users = null;
        try {
            users = new ArrayList<>();
            users.addAll(usuarioRepository.findAll());
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
    public Usuario getUser(Long id){
        Usuario user = null;
        try {
            user = usuarioRepository.getReferenceById(id);
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
    public Usuario createUser(Usuario usuario){
        Usuario user = null;
        try {
            user = usuarioRepository.save(usuario);
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
    public Usuario editUser(Usuario usuario){
        Usuario user = null;
        try {
            user = usuarioRepository.saveAndFlush(usuario);
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
            usuarioRepository.deleteById(id);
            delete = true;
        } catch (Exception e) {
        }
        return delete;
    }


}
