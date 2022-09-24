package com.example.demo.model;

import com.example.demo.enums.Enum_RoleName;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    private String nombre;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private Enum_RoleName rol;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToOne(targetEntity=Enterprise.class)
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Transaction> transactions = new ArrayList<>();
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updateAT;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdAt;

}
