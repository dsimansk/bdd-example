package com.github.zregvart.bdd.example.pages;

import java.util.function.Function;

import com.github.zregvart.bdd.example.support.WebStepsBase;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class CameleerDetail extends LoadableComponent<CameleerDetail> {

    @FindBy(css = ".add.button")
    WebElement addButton;

    @FindBy(css = ".close.button")
    WebElement closeButton;

    @FindBy(name = "description")
    WebElement descriptionElement;

    WebElement modal;

    @FindBy(name = "name")
    WebElement nameElement;

    public void addCamel(final String name, final String description) {
        nameElement.sendKeys(name);

        descriptionElement.sendKeys(description);

        addButton.click();

        closeButton.click();
    }

    @Override
    protected void isLoaded() throws Error {
        modal = WebStepsBase.STANDARD_WAIT.until((Function<WebDriver, WebElement>) driver -> WebStepsBase.DRIVER
                .findElement(By.cssSelector(".ui.modal.visible")));

        if (!modal.isDisplayed()) {
            throw new ElementNotVisibleException("Modal for editing Cameleer details is not (yet) visible");
        }

        PageFactory.initElements(WebStepsBase.DRIVER, this);
    }

    @Override
    protected void load() {
    }

}
