package com.example.demo.controller;

import com.example.demo.model.Transaction;
import com.example.demo.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionServices service;
    
    /**
     * Endpoint que permite que: El sistema permite consultar todos los usuarios
     *
     *
     * @return List<Usuario>
     */
    @GetMapping("/transactions")
    private List<Transaction> getAllTransactions() {
        return service.getAllTransactions();
    }

    /**
     * Endpoint que permite que: El sistema permite consultar un solo usuario
     *
     * @param id
     * @return Usuario
     */
    @GetMapping("/transaction/{id}")
    private Transaction getTransaction(@PathVariable("id") long id) {
        return service.getTransaction(id);
    }

    /**
     * Endpoint que permite que: El sistema permite crear un usuario
     *
     * @param usuario
     * @return Usuario
     */
    @PostMapping("/transaction")
    private void createTransaction(@RequestBody Transaction usuario) {
        service.createTransaction(usuario);
    }

    /**
     * Endpoint que permite que: El sistema permite editar un usuario
     *
     * @param usuario
     * @return Usuario
     */
    @PutMapping("/transaction")
    private void editTransaction(@RequestBody Transaction usuario) {
        service.editTransaction(usuario);
    }

    /**
     * Endpoint que permite que: El sistema permite eliminar un usuario
     *
     * @param id
     * @return Usuario
     */
    @DeleteMapping("/transaction/{id}")
    private void deleteTransaction(@PathVariable("id") long id) {
        service.deleteTransaction(id);
    }

}
