package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String  image;
    private String telefono;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private User usuario;

    private Date updateAT;
    private Date createdAt;
}
