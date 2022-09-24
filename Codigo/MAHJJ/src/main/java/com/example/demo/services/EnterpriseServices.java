package com.example.demo.services;

import com.example.demo.model.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.repository.EnterpriseRepository;

@Service
public class EnterpriseServices {

    @Autowired
    EnterpriseRepository repository;
        
    /**
    *  El sistema permite consultar todos los empresas
    *
    * 
    * @return List<Usuario>
    */
    public List<Enterprise> getAllEnterprises(){
        List<Enterprise> dataList = null;
        try {
            dataList = new ArrayList<>();
            dataList.addAll(repository.findAll());
        } catch (Exception e) {
            System.err.println("ERROR");
        }
        return  dataList;
    }
    
    /**
    * El sistema permite consultar un solo empresa
    *
    * @param id 
    * @return Usuario
    */
    public Enterprise getEnterprise(Long id){
        Enterprise data = null;
        try {
            data = repository.getReferenceById(id);
        } catch (Exception e) {
            System.err.println("ERROR");
        }
        return data;
    }

    /**
    * El sistema permite crear un empresa
    *
    * @param empresa 
    * @return Usuario
    */
    public Enterprise createEnterprise(Enterprise empresa){
        Enterprise data = null;
        try {
            data = repository.save(empresa);
        } catch (Exception e) {
        }
        return data;
    }
    
    /**
    * El sistema permite editar un empresa
    *
    * @param empresa 
    * @return Usuario
    */
    public Enterprise editEnterprise(Enterprise empresa){
        Enterprise data = null;
        try {
            data = repository.saveAndFlush(empresa);
        } catch (Exception e) {
        }
        return data;
    }

    /**
    * El sistema permite eliminar un empresa
    *
    * @param id 
    * @return Usuario
    */
    public boolean deleteEnterprise(Long id){
        Boolean delete = false;
        try {
            repository.deleteById(id);
            delete = true;
        } catch (Exception e) {
        }
        return delete;
    }


}
