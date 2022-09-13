package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity

public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column( name = "nombre",unique = true)
    private String  nombre;


    @Column( name = "documento",unique = true)
    private String  documento;



    private  String telefono;
    private  String  direccion;

    private Date updateAT;
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
