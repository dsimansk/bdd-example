package com.github.zregvart.bdd.example;

import com.github.zregvart.bdd.example.support.WebStepsBase;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, glue = {"com.github.zregvart.bdd.example.steps",
        "com.github.zregvart.bdd.example.support", "cucumber.api.spring"})
public class EndToEndTest {

    @AfterClass
    public static void shutdown() {
        WebStepsBase.DRIVER.quit();
    }
}
