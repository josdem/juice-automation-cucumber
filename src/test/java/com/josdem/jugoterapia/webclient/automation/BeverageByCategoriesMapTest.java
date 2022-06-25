package com.josdem.jugoterapia.webclient.automation;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.josdem.jugoterapia.webclient.automation.config.TestDataSource;
import com.josdem.jugoterapia.webclient.service.BeverageService;
import com.josdem.jugoterapia.webclient.service.CategoryService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BeverageByCategoriesMapTest extends JuiceIntegrationTest {

  private static final int EXPECTED_CATEGORY_ID = 5;
  private static final int EXPECTED_BEVERAGE_ID = 85;

  private final CategoryService categoryService;
  private final BeverageService beverageService;
  private final TestDataSource data;

  @Given("List of map categories")
  public void shouldGetCategories() {
    log.info("Running: List of categories");
    Flux<Map> publisher =
        categoryService.getCategoriesByLanguageMap("en").filter(it -> (int) it.get("id") == 5);
    StepVerifier.create(publisher)
        .assertNext(
            category -> {
              assertEquals(5, ((Map) category).get("id"));
              assertEquals("Healing", ((Map) category).get("name"));
            })
        .verifyComplete();
  }

  @When("I get a map beverages by category")
  public void shouldGetBeveragesById() {
    log.info("Running: I get beverages by category");
    Flux<Map> publisher =
        categoryService
            .getBeveragesByCategoryMap(EXPECTED_CATEGORY_ID)
            .filter(it -> (int) it.get("id") == 85);
    StepVerifier.create(publisher)
        .assertNext(
            beverage -> {
              assertEquals(data.getBeverage().getId(), beverage.get("id"));
              assertEquals(data.getBeverage().getName(), beverage.get("name"));
              assertEquals(data.getBeverage().getIngredients(), beverage.get("ingredients"));
              assertEquals(data.getBeverage().getImage(), beverage.get("image"));
            })
        .verifyComplete();
  }

  @Then("I get a map specific beverage")
  public void shouldGetSpecificBeverage() {
    log.info("Running: I get specific beverage");
    Mono<Map> publisher = beverageService.getBeverageAsMap(EXPECTED_BEVERAGE_ID);
    StepVerifier.create(publisher)
        .assertNext(
            beverage -> {
              assertAll(
                  "beverage",
                  () -> assertEquals(data.getBeverage().getId(), beverage.get("id")),
                  () -> assertEquals(data.getBeverage().getName(), beverage.get("name")),
                  () ->
                      assertEquals(
                          data.getBeverage().getIngredients(), beverage.get("ingredients")),
                  () -> assertEquals(data.getBeverage().getRecipe(), beverage.get("recipe")),
                  () -> assertEquals(data.getBeverage().getImage(), beverage.get("image")));
            })
        .verifyComplete();
  }
}
