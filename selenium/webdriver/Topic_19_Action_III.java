package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_19_Action_III {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        action = new Actions(driver);
    }

    // 2- Action/ Excute: Tương tác lên element nào/ nhập liệu/ verify/ ...
    @Test
    public void TC_01_Drag_Drop_HTML4() {
        driver.get("https://automationfc.github.io/kendo-drag-drop/");

        WebElement sourceCircle = driver.findElement(By.cssSelector("div#draggable"));
        WebElement targetCircle = driver.findElement(By.cssSelector("div#droptarget"));

        action.dragAndDrop(sourceCircle, targetCircle).perform();

        Assert.assertEquals(targetCircle.getText(), "You did great!");

        Assert.assertEquals(Color.fromString(targetCircle.getCssValue("background-color")).asHex().toUpperCase(),
                "#03A9F4");

    }

    @Test
    public void TC_02_Drag_Drop_HTML5() throws InterruptedException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");

        WebElement sourceSquare = driver.findElement(By.cssSelector("div#column-a"));
        WebElement targetSquare = driver.findElement(By.cssSelector("div#column-a"));

        action.dragAndDrop(sourceSquare, targetSquare).perform();

        // action.dragAndDrop(sourceSquare, targetSquare).perform();
        // Thread.sleep(3000);

        action.clickAndHold(sourceSquare)
                .moveToElement(targetSquare)
                .release()
                .perform();
        Thread.sleep(3000);
        // ko support HTML 5

    }

    @Test
    public void TC_02_() {

    }

    // 3- Clean: delete data test/ account/ closed browser/ ...
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}
