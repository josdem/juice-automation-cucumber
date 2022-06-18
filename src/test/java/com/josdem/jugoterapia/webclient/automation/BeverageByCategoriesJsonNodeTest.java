package com.josdem.jugoterapia.webclient.automation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BeverageByCategoriesJsonNodeTest extends JuiceIntegrationTest {

  @Given("A List of categories")
  public void shouldGetCategories(TestInfo testInfo) {
    System.out.println("Running: " + testInfo.getDisplayName());
  }

  @When("I get beverages by category")
  public void shouldGetBeveragesById(TestInfo testInfo) {
    System.out.println("Running: " + testInfo.getDisplayName());
  }

  @Then("I get specific beverage")
  public void shouldGetSpecificBeverage(TestInfo testInfo) {
    System.out.println("Running: " + testInfo.getDisplayName());
    assertTrue(false);
  }
}
