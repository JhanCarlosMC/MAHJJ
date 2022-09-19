package com.example.demo.controller;

import com.example.demo.model.Enterprise;
import com.example.demo.model.Usuario;
import com.example.demo.services.EnterpriseServices;
import com.example.demo.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnterpriseController {

    @Autowired
    EnterpriseServices enterpriseServices;

    @GetMapping("/enterprise")
    private List<Enterprise> verEnterprise(){
        return  enterpriseServices.verEnterprise();

    }
/*
    @PostMapping("/enteprise")
    private  void crearEnterprise(@RequestBody Enterprise enterprise){

        EnterpriseServices.
    }*/
    @DeleteMapping("/enterprise/{id}")
    private void eliminarEnterprise(@PathVariable("id") long id){

        enterpriseServices.eliminarEnterprise(id);
    }
    @PutMapping("/enterprise")
    private void editarEnterprise(@RequestBody Enterprise enterprise){
        enterpriseServices.crearYactualizarEnterprise(enterprise);
    }
}
