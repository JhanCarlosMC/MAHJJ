package com.MAHJJ.MAHJJ.entity;

import javax.persistence.OneToMany;

public class Enterprise {

    @OneToMany
    private Employee employee;
}
