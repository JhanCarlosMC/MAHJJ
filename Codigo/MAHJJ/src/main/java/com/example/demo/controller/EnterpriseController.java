package com.example.demo.controller;

import com.example.demo.dto.Mensaje;
import com.example.demo.model.Enterprise;
import com.example.demo.model.Transaction;
import com.example.demo.model.Usuario;
import com.example.demo.services.EnterpriseServices;
import com.example.demo.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
public class EnterpriseController {

    @Autowired
    EnterpriseServices enterpriseServices;

    @GetMapping("/enterprise")
    private List<Enterprise> verEnterprise(){
        return  enterpriseServices.verEnterprise();

    }

    @GetMapping("/enterprise/{id}")
    private Enterprise verEnterprise(@PathVariable("id") int id){
        return  enterpriseServices.verEnterprise().get(id);

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

    @GetMapping("/enterprises/{id}/movements")
    public List<Transaction> ListarTransacciones(){
        //return  enterpriseServices.listarTransacciones();
        return null;
    }

    @PostMapping("/enterprises/{id}/movements")
    public ResponseEntity<Mensaje> crearTransaccion(@RequestBody Transaction transaccion){
        try {
            //enterpriseServices.guardarTransaccion(transaccion);
            return  ResponseEntity.status(201).body(new Mensaje("La transaccion se registro correctamente"));

        } catch (Exception e) {
            return  ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PutMapping("/enterprises/{id}/movements")
    public ResponseEntity<Mensaje> actualizarTransaccion(@RequestBody Transaction transaccion) {
        try {
            //enterpriseServices.actualizarTransaccion(transaccion);
            return  ResponseEntity.status(200).body(new Mensaje("La transaccion se registro correctamente"));
        } catch (Exception e) {
            return  ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @DeleteMapping("enterprises/{idE}/movements/{id}")
    public ResponseEntity<Mensaje> eliminarTransaccion(@PathVariable("id")Integer id){
        try {
            //enterpriseServices.eliminarProducto(id);
            return  ResponseEntity.status(200).body(new Mensaje("La transaccion se elimino correctamente"));

        } catch (Exception e) {
            return  ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }
}
