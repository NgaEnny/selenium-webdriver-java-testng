package webdriver;

import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_14_Checkbox_Radio {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;
    JavascriptExecutor jsExecutor;


    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        jsExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        // Kích thước của browser là 1366x768
    //   driver.manage().window().setSize(new Dimension(1366, 768));
    }

    @Test
    public void TC_01_Telerik() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");

        // Verify checkbox/ radio is enabled/ disabled
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input")).isEnabled());

        // Verify checkbox/ radio is selected/ deselected
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input")).isSelected());

        // Select to "Dual-zone air conditioning" checkbox
        By dualZoneAirBy = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

        // Scroll xuống thêm 1 đoạn 300 px
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");

        // Nếu như chưa chọn thì mới click
        if (!driver.findElement(dualZoneAirBy).isSelected()) {
            driver.findElement(dualZoneAirBy).click();
        }
        Assert.assertTrue(driver.findElement(dualZoneAirBy).isSelected());

        // De-select to "Dual-zone air conditioning" checkbox (bỏ chọn)
        if (driver.findElement(dualZoneAirBy).isSelected()) {
            driver.findElement(dualZoneAirBy).click();
        }
        Assert.assertFalse(driver.findElement(dualZoneAirBy).isSelected());

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");

        By twoPetrolBy = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");

        if (!driver.findElement(twoPetrolBy).isSelected()) {
            driver.findElement(twoPetrolBy).click();
        }

        Assert.assertTrue(driver.findElement(twoPetrolBy).isSelected());

    }

    @Test
    public void TC_02_Multiple() {
        driver.get("https://automationfc.github.io/multiple-fields/");

        // Select all checkboxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("span.form-checkbox-item>input"));

        // Click all checkboxes nếu chưa được chọn
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }

        // Verify all checkboxes selected
        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }

        // Deselect all checkboxes
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }

        // Verify all checkboxes deselected
        for (WebElement checkbox : checkboxes) {
            Assert.assertFalse(checkbox.isSelected());
        }

        // Select 1 in all + verify
        driver.findElement(By.cssSelector("input[value='Venereal Disease']")).click();
        driver.findElement(By.cssSelector("input[value='High Blood Pressure']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Venereal Disease']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='High Blood Pressure']")).isSelected());

        // Select 1 in all + verify
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected() && checkbox.getAttribute("value").equals("Heart Attack")) {
                checkbox.click();
            }
        }

        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Heart Attack']")).isSelected());

    }

    @Test
    public void TC_03_Ubuntu() {
        driver.get("https://login.ubuntu.com/");

        // Thẻ input: dùng để click
        // Dùng để verify: isSelected()

        By newUserRadio = By.cssSelector("input#id_new_user");

        // 1 - Dùng thẻ input để click -> Fail
        // Dùng thẻ input này để verify -> Pass
        // driver.findElement(newUserRadio).click();
        // Assert.assertFalse(driver.findElement(newUserRadio).isSelected());

        // By newUserRadio = By.cssSelector("label.new-user");
        // 2 - Dùng 1 thẻ khác input để click -> Pass
        // Dùng thẻ đó để verify -> Fail
        // isSelected() -> Dùng cho thẻ input/option
        // driver.findElement(newUserRadio).click();
        // Assert.assertTrue(driver.findElement(newUserRadio).isSelected());

        // 3 - Dùng 1 thẻ khác input để click -> Pass
        // Dùng thẻ input này để verify -> Pass
        // By newUserRadioLabel = By.cssSelector("label.new-user");
        // By newUserRadioInput = By.cssSelector("input#id_new_user");
        // driver.findElement(newUserRadioLabel).click();
        // Assert.assertTrue(driver.findElement(newUserRadioInput).isSelected());

        // 4 - Dùng duy nhất thẻ input để click / verify dùng JS Executor
        By newUserRadioInput = By.cssSelector("input#id_new_user");
        jsExecutor.executeScript("arguments[0].click();",driver.findElement(newUserRadioInput));
        Assert.assertTrue(driver.findElement(newUserRadioInput).isSelected());

        By termCheckbox = By.cssSelector("input#id_accept_tos");
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(termCheckbox));
        Assert.assertTrue(driver.findElement(termCheckbox).isSelected());
    }

    @Test
    public void TC_04_Docs() throws InterruptedException {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        Thread.sleep(3000);

        By hcmRadio = By.xpath("//div[@aria-label='Hồ Chí Minh']");
        By quangNoodleCheckbox = By.xpath("//div[@aria-label='Mì Quảng']");

        driver.findElement(hcmRadio).click();
        Assert.assertEquals(driver.findElement(hcmRadio).getAttribute("aria-checked"), "true");

        // Check
        if (driver.findElement(quangNoodleCheckbox).getAttribute("aria-checked").equals("false")) {
            driver.findElement(quangNoodleCheckbox).click();
        }

        Assert.assertEquals(driver.findElement(quangNoodleCheckbox).getAttribute("aria-checked"), "true");

        // Uncheck
        if (driver.findElement(quangNoodleCheckbox).getAttribute("aria-checked").equals("true")) {
            driver.findElement(quangNoodleCheckbox).click();
        }

        Assert.assertEquals(driver.findElement(quangNoodleCheckbox).getAttribute("aria-checked"), "false");
    }


    // 3- Clean: delete data test/ account/ closed browser/ ...
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}
