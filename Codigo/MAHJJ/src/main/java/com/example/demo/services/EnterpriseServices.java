package com.example.demo.services;

import com.example.demo.model.Enterprise;
import com.example.demo.model.Usuario;
import com.example.demo.repository.EnterpriseRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EnterpriseServices {

    @Autowired
    EnterpriseRepository enterpriseRepository;


    public void  crearYactualizarEnterprise(Enterprise enterprise){

        enterpriseRepository.save(enterprise);

    }

    public List<Enterprise> verEnterprise(){

        List<Enterprise> enterprises = new ArrayList<Enterprise>();
        enterprises.addAll(enterpriseRepository.findAll());
        return  enterprises;
    }

    public void  eliminarEnterprise(Long id){

        enterpriseRepository.deleteById(id);

    }
}
