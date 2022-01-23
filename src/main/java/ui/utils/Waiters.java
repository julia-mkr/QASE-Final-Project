package ui.utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Log4j2
public class Waiters {

    public static void waitForElementBecomesVisible(WebDriver driver, By element, int timeout) {
        log.debug("The timeout for waiting for" + element + " becomes visible is " + timeout);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitForElementLocated(WebDriver driver, WebElement element, int timeout) {
        log.debug("The timeout for waiting for " + element + " located is " + timeout);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementsBecomeVisible(WebDriver driver, List<WebElement> elements, int timeout) {
        log.debug("The timeout for waiting for " + elements + " become visible is " + timeout);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
