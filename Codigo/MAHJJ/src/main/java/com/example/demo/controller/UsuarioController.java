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
@GetMapping("/usuario")
private List<Usuario> verUsuario(){
    return  usuarioServices.verUsuario();

}



@PostMapping("/usuario")
private  void crearUsuario(@RequestBody Usuario usuario){

    usuarioServices.crearYactualizarUsuario(usuario);
}
@DeleteMapping("/usuario/{id}")
private void eliminarUsuario(@PathVariable("id") long id){

    usuarioServices.eliminarUsuario(id);
}
@PutMapping("/usuario")
private void editarUsuario(@RequestBody Usuario usuario){
usuarioServices.crearYactualizarUsuario(usuario);
}
}
