package com.example.demo.model;

import com.example.demo.enums.Enum_NombreRol;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private  Long id;


    @Column( name = "email",unique = true)
    private String  email;

    private String  nombre;
 @Enumerated(EnumType.STRING)
 @Column(name = "ROLES")
    private Enum_NombreRol roles;
 @OneToOne (mappedBy = "usuario")
   private Perfil perfil;
   // @ManyToOne
    //private Enterprise enterprise;
   // private Date updateAT;
    //private Date createdAt;




}
