package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany
    private Usuario usuario;
    @Column(name = "nombre", nullable = false, unique = true, length = 50)
    private String nombre;

    @Column(name = "documento", nullable = false, unique = true, length = 50)
    private String documento;

    @Column(name = "telefono", length = 15)
    private String  telefono;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;


    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

    private List<Usuario> usuarios = new ArrayList<>();




}
