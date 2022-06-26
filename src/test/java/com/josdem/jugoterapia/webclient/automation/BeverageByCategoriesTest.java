package com.josdem.jugoterapia.webclient.automation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.josdem.jugoterapia.webclient.automation.config.TestDataSource;
import com.josdem.jugoterapia.webclient.model.Beverage;
import com.josdem.jugoterapia.webclient.model.Category;
import com.josdem.jugoterapia.webclient.service.BeverageService;
import com.josdem.jugoterapia.webclient.service.CategoryService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

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
    Flux<Category> publisher =
        categoryService
            .getCategoriesByLanguage("en")
            .filter(category -> category.getId() == EXPECTED_CATEGORY_ID);
    StepVerifier.create(publisher)
        .assertNext(
            category -> {
              assertEquals(5, category.getId());
              assertEquals("Healing", category.getName());
            })
        .verifyComplete();
  }

  @When("I get beverages by category")
  public void shouldGetBeveragesById() {
    log.info("Running: I get beverages by category");
    Flux<Beverage> publisher =
        categoryService
            .getBeveragesByCategory(EXPECTED_CATEGORY_ID)
            .filter(beverage -> beverage.getId() == EXPECTED_BEVERAGE_ID);
    StepVerifier.create(publisher)
        .assertNext(
            beverage -> {
              assertEquals(data.getBeverage().getId(), beverage.getId());
              assertEquals(data.getBeverage().getName(), beverage.getName());
              assertNotNull(data.getBeverage().getIngredients());
              assertEquals(data.getBeverage().getImage(), beverage.getImage());
            })
        .verifyComplete();
  }

  @Then("I get a specific beverage")
  public void shouldGetSpecificBeverage() {
    log.info("Running: I get specific beverage");
    Mono<Beverage> publisher = beverageService.getBeverage(EXPECTED_BEVERAGE_ID);
    StepVerifier.create(publisher).expectNext(data.getBeverage()).verifyComplete();
  }
}
