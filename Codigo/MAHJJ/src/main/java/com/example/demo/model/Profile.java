package com.example.demo.model;

import java.io.Serializable;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "profile")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class Profile implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String  image;
    
    private String phone;
    
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updateAT;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdAt;
}
