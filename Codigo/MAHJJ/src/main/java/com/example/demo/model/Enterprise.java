package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "enterprise")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "enterprise")
    private  List <User>usuarios;
    
    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "document", unique = true)
    private String document;

    private String  phone;

    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<User> users = new ArrayList<>();
    
    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Transaction> transactions = new ArrayList<>();
        
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdAt;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updatedAt;
}
