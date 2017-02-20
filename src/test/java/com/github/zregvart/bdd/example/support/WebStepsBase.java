package com.github.zregvart.bdd.example.support;

import java.util.concurrent.TimeUnit;

import com.github.zregvart.bdd.example.Application;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Application.class)
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class WebStepsBase {

    public static final WebDriver DRIVER = new FirefoxDriver();

    public static final FluentWait<WebDriver> STANDARD_WAIT = new FluentWait<>(WebStepsBase.DRIVER)
            .withTimeout(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

    private final String home;

    public WebStepsBase(final int port) {
        home = "http://localhost:" + port;
    }

    public void naviagateHome() {
        DRIVER.get(home);
    }

    public void navigateTo(final String path) {
        DRIVER.get(home + path);
    }

}
