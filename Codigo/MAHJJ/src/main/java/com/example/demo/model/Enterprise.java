package com.example.demo.model;

import javax.persistence.OneToMany;

public class Enterprise {

    @OneToMany
    private Usuario usuario;
}
