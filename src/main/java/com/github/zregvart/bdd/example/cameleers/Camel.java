package com.github.zregvart.bdd.example.cameleers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Camel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    String description;

    public Camel(final String name, String description) {
        this.name = name;
        this.description = description;
    }

    Camel() {
    }

}
