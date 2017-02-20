package com.github.zregvart.bdd.example.cameleers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Cameleer {

    @OneToMany(targetEntity = Camel.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Camel> camels;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    public Cameleer(final String name) {
        this.name = name;
    }

    Cameleer() {
    }

}
