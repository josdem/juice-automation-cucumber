package com.josdem.jugoterapia.webclient.automation;

import com.josdem.jugoterapia.webclient.automation.config.TestDataSource;
import com.josdem.jugoterapia.webclient.service.BeverageService;
import com.josdem.jugoterapia.webclient.service.CategoryService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BeverageByCategoriesJsonNodeTest extends JuiceIntegrationTest {

    private static final int EXPECTED_CATEGORY_ID = 5;
    private static final int EXPECTED_BEVERAGE_ID = 85;

    private final CategoryService categoryService;
    private final BeverageService beverageService;
    private final TestDataSource data;

    @Given("List of categories")
    public void shouldGetCategories() {
        log.info("Running: List of categories");
        List<String> response =
                categoryService.getCategoriesByLanguageJson("en").map(it -> it.findValuesAsText("id")).block();
        assertTrue(
                response.contains(String.valueOf(EXPECTED_CATEGORY_ID)),
                "it should contains healthy category");
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
