package ui.utils;

import org.openqa.selenium.WebDriver;
import ui.objects.TestCase;
import ui.pages.CreateTestCasePage;

public class VerificationUtils {

    public static boolean verifyTestCaseInputFieldsAndDropdownOption (WebDriver driver, TestCase testCase) {
        boolean result = false;
        if (!testCase.getTitle().isEmpty()) {
            result = CreateTestCasePage.isEnteredTextDisplayed(driver, testCase.getTitle());
        }
        if (!testCase.getPriority().isEmpty()) {
            result = CreateTestCasePage.isOptionDisplayed(driver, testCase.getPriority());
        }
        if (!testCase.getType().isEmpty()) {
            result = CreateTestCasePage.isOptionDisplayed(driver, testCase.getType());
        }
        if (!testCase.getLayer().isEmpty()) {
            result = CreateTestCasePage.isOptionDisplayed(driver, testCase.getLayer());
        }
        if (!testCase.getAutomationStatus().isEmpty()) {
            result = CreateTestCasePage.isOptionDisplayed(driver, testCase.getAutomationStatus());
        }
        return result;
    }

    public static boolean verifyTestCaseInputAndTextFields(WebDriver driver, TestCase testCase) {
        boolean result = false;
        if (!testCase.getTitle().isEmpty()) {
            result = CreateTestCasePage.isEnteredTextDisplayed(driver, testCase.getTitle());
        }
        if (!testCase.getDescription().isEmpty()) {
            result = CreateTestCasePage.isEnteredTextDisplayed(driver, testCase.getDescription());
        }
        if (!testCase.getPreConditions().isEmpty()) {
            result = CreateTestCasePage.isEnteredTextDisplayed(driver, testCase.getPreConditions());
        }
        if (!testCase.getPostConditions().isEmpty()) {
            result = CreateTestCasePage.isEnteredTextDisplayed(driver, testCase.getPostConditions());
        }
        if (!testCase.getAction().isEmpty()) {
            result = CreateTestCasePage.isEnteredTextDisplayed(driver, testCase.getAction());
        }
        if (!testCase.getInputData().isEmpty()) {
            result = CreateTestCasePage.isEnteredTextDisplayed(driver, testCase.getInputData());
        }
        if (!testCase.getExpectedResult().isEmpty()) {
            result = CreateTestCasePage.isEnteredTextDisplayed(driver, testCase.getExpectedResult());
        }
        return result;
    }
}
