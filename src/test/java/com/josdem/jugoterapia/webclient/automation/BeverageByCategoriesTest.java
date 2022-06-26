package com.josdem.jugoterapia.webclient.automation;

import com.fasterxml.jackson.databind.JsonNode;
import com.josdem.jugoterapia.webclient.automation.config.TestDataSource;
import com.josdem.jugoterapia.webclient.service.BeverageService;
import com.josdem.jugoterapia.webclient.service.CategoryService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BeverageByCategoriesTest extends JuiceIntegrationTest {

  private static final int EXPECTED_CATEGORY_ID = 5;
  private static final int EXPECTED_BEVERAGE_ID = 85;

  private final CategoryService categoryService;
  private final BeverageService beverageService;
  private final TestDataSource data;

  @Given("List of categories")
  public void shouldGetCategories() {
    log.info("Running: List of categories");
    Mono<List<String>> publisher =
        categoryService.getCategoriesByLanguageJson("en").map(it -> it.findValuesAsText("id"));
    StepVerifier.create(publisher)
        .assertNext(
            categoriesIds -> {
              assertTrue(
                  categoriesIds.contains(String.valueOf(EXPECTED_CATEGORY_ID)),
                  "it should contains healthy category");
            })
        .verifyComplete();
  }

  @When("I get beverages by category")
  public void shouldGetBeveragesById() {
    log.info("Running: I get beverages by category");
    Mono<List<String>> publisher =
        categoryService
            .getBeveragesByCategoryJson(EXPECTED_CATEGORY_ID)
            .map(it -> it.findValuesAsText("id"));
    StepVerifier.create(publisher)
        .assertNext(
            beveragesIds -> {
              assertTrue(
                  beveragesIds.contains(String.valueOf(EXPECTED_BEVERAGE_ID)),
                  "it should contains Anti-constipation Smoothie beverage");
            })
        .verifyComplete();
  }

  @Then("I get a specific beverage")
  public void shouldGetSpecificBeverage() {
    log.info("Running: I get specific beverage");
    Mono<JsonNode> publisher = beverageService.getBeverageAsJson(EXPECTED_BEVERAGE_ID);
    StepVerifier.create(publisher)
        .assertNext(
            beverage -> {
              assertAll(
                  "beverage",
                  () -> assertEquals(data.getBeverage().getId(), beverage.get("id").asInt()),
                  () -> assertEquals(data.getBeverage().getName(), beverage.get("name").asText()),
                  () ->
                      assertEquals(
                          data.getBeverage().getIngredients(),
                          beverage.get("ingredients").asText()),
                  () ->
                      assertEquals(data.getBeverage().getRecipe(), beverage.get("recipe").asText()),
                  () ->
                      assertEquals(data.getBeverage().getImage(), beverage.get("image").asText()));
            })
        .verifyComplete();
  }
}
