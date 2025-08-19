package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_XPath_Css {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://live.techpanda.org");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // 2- Action/ Excute: Tương tác lên element nào/ nhập liệu/ verify/ ...
    @Test
    public void Register_01_Empty_Data() {
        // Arrange
       driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        // Action
       driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Assert
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
    }

    @Test
    public void Register_02_Invalid_Email() {
        // Arrange
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Biden");
        driver.findElement(By.id("txtEmail")).sendKeys("123@345@321");
        driver.findElement(By.id("txtCEmail")).sendKeys("123@345@321");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
    }

    @Test
    public void Register_03_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Biden");
        driver.findElement(By.id("txtEmail")).sendKeys("john@biden.us");
        driver.findElement(By.id("txtCEmail")).sendKeys("john@biden.vn");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(
                driver.findElement(By.id("txtCEmail-error")).getText(),
                "Email nhập lại không đúng"
        );
    }

    @Test
    public void Register_04_Invalid_Password() {
        // Arrange
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.id("txtPassword")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void Register_05_Incorrect_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Biden");
        driver.findElement(By.id("txtEmail")).sendKeys("john@biden.us");
        driver.findElement(By.id("txtCEmail")).sendKeys("john@biden.us");

        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("654321");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(
                driver.findElement(By.id("txtCPassword-error")).getText(),
                "Mật khẩu bạn nhập không khớp"
        );
    }

    @Test
    public void Register_06_Invalid_Phone_Number() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Biden");
        driver.findElement(By.id("txtEmail")).sendKeys("john@biden.us");
        driver.findElement(By.id("txtCEmail")).sendKeys("john@biden.us");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("654321");

        // < 10 numbers
        driver.findElement(By.id("txtPhone")).sendKeys("098765432");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(
                driver.findElement(By.id("txtPhone-error")).getText(),
                "Số điện thoại phải từ 10-11 số."
        );

        // > 11 numbers
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("0987654321456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(
                driver.findElement(By.id("txtPhone-error")).getText(),
                "Số điện thoại phải từ 10-11 số."
        );

        // Start with invalid prefix (not 09/03/012/016/018/019/088/03/05 per UI)
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("7654321456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(
                driver.findElement(By.id("txtPhone-error")).getText(),
                "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08"
        );
    }

    // 3- Clean: delete data test/ account/ closed browser/ ...
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}
