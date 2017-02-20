package com.github.zregvart.bdd.example.steps;

import java.net.UnknownHostException;
import java.util.List;

import com.github.zregvart.bdd.example.cameleers.Camel;
import com.github.zregvart.bdd.example.cameleers.Cameleer;
import com.github.zregvart.bdd.example.cameleers.CameleerRepository;
import com.github.zregvart.bdd.example.pages.CameleerCard;
import com.github.zregvart.bdd.example.pages.CameleerDetail;
import com.github.zregvart.bdd.example.support.WebStepsBase;

import org.springframework.boot.context.embedded.LocalServerPort;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CameleersSteps extends WebStepsBase {

    final CameleerRepository repository;

    CameleersSteps(final CameleerRepository repository, @LocalServerPort final int port) throws UnknownHostException {
        super(port);
        this.repository = repository;
    }

    @Given("^a cameleer \"([^\"]*)\" with camels:$")
    public void a_cameleer_with_camels(final String cameleerName, final List<Camel> camels) throws Throwable {
        final Cameleer cameleer = new Cameleer(cameleerName);
        cameleer.setCamels(camels);

        repository.save(cameleer);
    }

    @When("^I add a camel named \"([^\"]*)\" with description \"([^\"]*)\"$")
    public void i_add_a_camel_named_with_description(final String name, final String description) throws Throwable {
        final CameleerDetail detail = new CameleerDetail().get();

        detail.addCamel(name, description);
    }

    @Then("^I am presented with cameleer \"([^\"]*)\" with (\\d+) camel(?:s)?$")
    public void i_am_presented_with_cameleer(final String cameleerName, final int numberOfCamels) throws Throwable {
        final CameleerCard cameleerCard = new CameleerCard(this, cameleerName).get();

        assertEquals(String.format("There should be a Cameleer with the name: `%s` and a herd of %d", cameleerName,
                numberOfCamels), numberOfCamels, cameleerCard.getNumberOfCamels());
    }

    @When("^I edit the cameleer \"([^\"]*)\"$")
    public void i_edit_the_cameleer(final String cameleerName) throws Throwable {
        final CameleerCard cameleerCard = new CameleerCard(this, cameleerName).get();

        cameleerCard.edit();
    }

    @When("^I open the Cameleers application$")
    public void i_open_the_Cameleers_application() throws Throwable {
        naviagateHome();
    }

    @Before
    public void resetTheDatabase() {
        repository.deleteAll();
    }

}
