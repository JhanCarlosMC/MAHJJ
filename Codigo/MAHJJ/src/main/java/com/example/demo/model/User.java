package com.example.demo.model;

import com.example.demo.enums.Enum_NombreRol;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    private String nombre;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLES")
    private Enum_NombreRol roles;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Perfil perfil;

    //@ManyToOne(targetEntity=Enterprise.class)
    //@JoinColumn(name = "usuarios")
    //private Enterprise enterprise;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Transaction> transactions = new ArrayList<>();
    
    @ManyToOne
    private Enterprise enterprise;
    
    private Date updateAT;
    
    private Date createdAt;

    @Override
    public String toString() {
        return "Usuario{"
                + "id=" + id
                + ", email='" + email + '\''
                + ", perfil=" + perfil
                + ", roles=" + roles
                + ", enterprise=" + enterprise
                + ", transactions=" + transactions
                + ", createdAt=" + createdAt
                + ", updatedAt=" + updateAT
                + '}';
    }

}
