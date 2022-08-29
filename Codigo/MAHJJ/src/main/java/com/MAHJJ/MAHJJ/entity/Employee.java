package com.MAHJJ.MAHJJ.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "employee")
public class Employee {

   @Id

    private  long id;
 @Column( name = "email",unique = true)
    private String  email;
@ManyToOne
 private Enterprise enterprise;
    private Date updateAT;
    private Date createdAt;

    public Employee() {
    }

    public Employee(long id, String email, Enterprise enterprise, Date updateAT, Date createdAt) {
        this.id = id;
        this.email = email;
        this.enterprise = enterprise;
        this.updateAT = updateAT;
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Date getUpdateAT() {
        return updateAT;
    }

    public void setUpdateAT(Date updateAT) {
        this.updateAT = updateAT;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
