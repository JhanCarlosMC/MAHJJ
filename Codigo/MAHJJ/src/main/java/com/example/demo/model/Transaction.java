package com.example.demo.model;

import java.io.Serializable;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String concept;

    private float amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdAt;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updatedAt;

    
}
