package com.github.zregvart.bdd.example.pages;

import java.util.function.Function;

import com.github.zregvart.bdd.example.support.WebStepsBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

public class CameleerCard extends LoadableComponent<CameleerCard> {

    final WebStepsBase base;

    final String cameleerName;

    WebElement card;

    final String expression;

    public CameleerCard(final WebStepsBase base, final String cameleerName) {
        this.base = base;
        this.cameleerName = cameleerName;

        expression = "//*[contains(@class, 'card') and not(contains(@class, 'cards'))][contains(., '" + cameleerName
            + "')]";
    }

    public void edit() {
        card.click();
    }

    public int getNumberOfCamels() {
        final WebElement countElement = card.findElement(By.cssSelector(".extra.content .count"));

        return Integer.parseInt(countElement.getText());
    }

    @Override
    protected void isLoaded() throws Error {
        card = WebStepsBase.STANDARD_WAIT
                .until((Function<WebDriver, WebElement>) driver -> driver.findElement(By.xpath(expression)));
    }

    @Override
    protected void load() {
        base.navigateTo("/cameleers");
    }

}
