package javaSDET;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06_Wait {

    WebDriver driver;
    WebDriverWait explicitWait;
    FluentWait<WebDriver> fluentWait; // Java Generic

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();

        // Explicit Wait
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Fluent Wait = dùng được cho tất cả test case trong class này
        fluentWait = new FluentWait<WebDriver>(driver);
    }

    @Test
    public void TC_01_() {
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        // Nội bộ của test case 1 thôi
        fluentWait = new FluentWait<WebDriver>(driver);

    }

}
