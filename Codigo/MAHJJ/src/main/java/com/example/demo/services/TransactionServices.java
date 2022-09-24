package com.example.demo.services;

import com.example.demo.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.repository.TransactionRepository;

@Service
public class TransactionServices {

    @Autowired
    TransactionRepository repository;
        
    /**
    *  El sistema permite consultar todos los movimientos
    *
    * 
    * @return List<Transaction>
    */
    public List<Transaction> getAllTransactions(){
        List<Transaction> dataList = null;
        try {
            dataList = new ArrayList<>();
            dataList.addAll(repository.findAll());
        } catch (Exception e) {
            System.err.println("ERROR");
        }
        return  dataList;
    }
    
    /**
    * El sistema permite consultar un solo movimiento
    *
    * @param id 
    * @return Usuario
    */
    public Transaction getTransaction(Long id){
        Transaction data = null;
        try {
            data = repository.getReferenceById(id);
        } catch (Exception e) {
            System.err.println("ERROR");
        }
        return data;
    }

    /**
    * El sistema permite crear un movimiento
    *
    * @param movimiento 
    * @return Usuario
    */
    public Transaction createTransaction(Transaction movimiento){
        Transaction data = null;
        try {
            data = repository.save(movimiento);
        } catch (Exception e) {
        }
        return data;
    }
    
    /**
    * El sistema permite editar un movimiento
    *
    * @param movimiento 
    * @return Usuario
    */
    public Transaction editTransaction(Transaction movimiento){
        Transaction data = null;
        try {
            data = repository.saveAndFlush(movimiento);
        } catch (Exception e) {
        }
        return data;
    }

    /**
    * El sistema permite eliminar un movimiento
    *
    * @param id 
    * @return Usuario
    */
    public boolean deleteTransaction(Long id){
        Boolean delete = false;
        try {
            repository.deleteById(id);
            delete = true;
        } catch (Exception e) {
        }
        return delete;
    }


}
