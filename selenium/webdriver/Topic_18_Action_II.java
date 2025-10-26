package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Topic_18_Action_II {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;
    WebDriverWait explicitWait;
    Actions action;
    String osName = System.getProperty("os.name"); // dùng cho MAC và Win
    Keys keys; // dùng cho MAC và Win

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
// hoặc
//        driver.manage().window().maximize();


        action = new Actions(driver);
        keys = osName.startsWith("Windows") ? Keys.CONTROL : Keys.COMMAND; // dùng cho MAC và Win
        // thay keys cho cả 2 Keys.CONTROL và Keys.COMMAND

    }

    // 2- Action/ Excute: Tương tác lên element nào/ nhập liệu/ verify/ ...
    @Test
    public void TC_01_Click_And_Hold_Block() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNumber = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allNumber.size(), 30);

        action.clickAndHold(allNumber.get(0))   // Click vào số 1 và giữ chuột
                .moveToElement(allNumber.get(3)) // Di chuột tới số 4
                .release()                       // Nhả chuột trái ra - kết thúc cho sự kiện clickAndHold()
                .perform();                      // Thực thi các câu lệnh trên

        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(allNumberSelected.size(), 4);
    }

    @Test
    public void TC_02_Click_And_Hold_Random() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNumber = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allNumber.size(), 30);

        // Nhấn phím Ctrl xuống (chưa nhả ra)
        action.keyDown(Keys.CONTROL).perform();

        action.click(allNumber.get(0))
                .click(allNumber.get(3))
                .click(allNumber.get(7))
                .click(allNumber.get(10))
                .click(allNumber.get(13))
                .click(allNumber.get(17))
                .pause(Duration.ofSeconds(3))
                .perform();

        // Nhả phím Ctrl ra
        action.keyUp(Keys.CONTROL).perform();

        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(allNumberSelected.size(), 6);

    }

//    @Test
//    public void TC_03_Double_Click() throws InterruptedException {
//        driver.get("https://automationfc.github.io/basic-form/index.html");
//
//        action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
//
//        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys");
//
//    }

    @Test
    public void TC_03_Double_Click() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Double click me']")));

        // 1) Đưa element vào giữa viewport
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", btn);

        // 2) Dùng Selenium 4: doubleClick vào chính element
        new Actions(driver).doubleClick(btn).perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("#demo")).getText(),
                "Hello Automation Guys!");
    }

    @Test
    public void TC_04_Right_Click() {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

        // Click chuột phải vào button
        action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();

        By quitContextBy = By.cssSelector("li.context-menu-icon-quit");

        Assert.assertTrue(driver.findElement(quitContextBy).isDisplayed());

        // Hover mouse
        action.moveToElement(driver.findElement(quitContextBy)).perform();

        Assert.assertTrue(driver.findElement(
                By.cssSelector("li.context-menu-icon-quit.context-menu-visible.context-menu-hover")).isDisplayed());

        // Click Quit
        action.click(driver.findElement(quitContextBy)).perform();
        driver.switchTo().alert().accept();

        Assert.assertFalse(driver.findElement(quitContextBy).isDisplayed());
    }



                // 3- Clean: delete data test/ account/ closed browser/ ...
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}
