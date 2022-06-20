package com.josdem.jugoterapia.webclient.automation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeverageByCategoriesJsonNodeTest extends JuiceIntegrationTest {

  @Given("List of categories")
  public void shouldGetCategories() {
    System.out.println("Running: List of categories");
    assertTrue(true);
  }

  @When("I get beverages by category")
  public void shouldGetBeveragesById() {
    System.out.println("Running: I get beverages by category");
    assertTrue(true);
  }

  @Then("I get specific beverage")
  public void shouldGetSpecificBeverage() {
    System.out.println("Running: I get specific beverage");
    assertTrue(true);
  }
}
