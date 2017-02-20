package com.github.zregvart.bdd.example;

import java.util.Arrays;
import java.util.List;

import com.github.zregvart.bdd.example.cameleers.Camel;
import com.github.zregvart.bdd.example.cameleers.Cameleer;
import com.github.zregvart.bdd.example.cameleers.CameleerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class InitialData implements CommandLineRunner {

    CameleerRepository cameleerRepository;

    @Autowired
    public InitialData(final CameleerRepository cameleerRepository) {
        this.cameleerRepository = cameleerRepository;
    }

    @Override
    public void run(final String... args) throws Exception {
        final Cameleer zoran = new Cameleer("Zoran");
        final List<Camel> camels = Arrays.asList(new Camel("Camila", "One hump"),
                new Camel("Boris", "Two humps, slight limp"));

        zoran.setCamels(camels);

        cameleerRepository.save(zoran);
    }

}
