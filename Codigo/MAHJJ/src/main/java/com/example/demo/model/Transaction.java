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
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "concepto", nullable = false)
    private String concepto;

    @Column(name = "monto", nullable = false)
    private float monto;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;


    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;


    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", concepto='" + concepto + '\'' +
                ", monto=" + monto +
                ", usuario=" + usuario +
                ", enterprise=" + enterprise +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
