package testConstants;

import ui.objects.TestCase;

public interface TestCaseConstants {

    TestCase DATA_FOR_TEST_CASE_1 = TestCase.builder()
            .title("Log in")
            .build();

    TestCase DATA_FOR_TEST_CASE_2 = TestCase.builder()
            .title("Sign in using valid data")
            .suite("Test cases without suite")
            .priority("High")
            .type("Regression")
            .layer("E2E")
            .automationStatus("To be automated")
            .build();

    TestCase DATA_FOR_TEST_CASE_3 = TestCase.builder()
            .title("Create a user")
            .description("Create a new user")
            .build();

    TestCase DATA_FOR_TEST_CASE_4 = TestCase.builder()
            .title("Add a product to the cart")
            .description("The test case checks, whether a product was added to cart, and the price of it")
            .preConditions("Open the website: www.website.com;")
            .postConditions("Delete a product from the cart and then sign out;")
            .action("Sign in")
            .inputData("Login: test@mail.com / Password: 123456789")
            .expectedResult("The homepage is displayed")
            .build();
}
