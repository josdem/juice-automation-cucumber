package com.josdem.jugoterapia.webclient.automation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class BeverageByCategoriesJsonNodeTest extends JuiceIntegrationTest {

  @Given("List of categories")
  public void shouldGetCategories() {
    log.info("Running: List of categories");
    assertTrue(true);
  }

  @When("I get beverages by category")
  public void shouldGetBeveragesById() {
    log.info("Running: I get beverages by category");
    assertTrue(true);
  }

  @Then("I get specific beverage")
  public void shouldGetSpecificBeverage() {
    log.info("Running: I get specific beverage");
    assertTrue(true);
  }
}
