package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic_11_Default_Dropdown {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;
    Select select;
    Random rand;
    String firstName, lastName, emailAddress, companyName, password, date, month, year;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        rand = new Random();

        firstName = "Dominique";
        lastName = "PLy";
        emailAddress = "mgrenfell" + rand.nextInt(99999) + "@illinois.edu";
        companyName = "Flashdog";
        date = "24";
        month = "August";
        year = "1996";
        password = "yT&DF1YpB{HxIR8";
    }


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver(); }

    // 2- Action/ Excute: Tương tác lên element nào/ nhập liệu/ verify/ ...
    @Test
    public void TC_01_Facebook_SignUp() {
        driver.get("https://www.facebook.com/reg/");

        select = new Select(driver.findElement(By.cssSelector("select#day")));
        select.selectByVisibleText("25");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "25");

        select = new Select(driver.findElement(By.cssSelector("select#month")));
        select.selectByVisibleText("Jun");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Jun");

        select = new Select(driver.findElement(By.cssSelector("select#year")));
        select.selectByVisibleText("2019");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "2019");
    }

    @Test
    public void TC_02_NopCommerce() {
        driver.get("https://demo.nopcommerce.com");

        driver.findElement(By.cssSelector("a.ico-register")).click();

        driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);

//        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).selectByVisibleText(date);
//        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).selectByVisibleText(month);
//        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).selectByVisibleText(year);

        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Company")).sendKeys(companyName);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("button#register-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.registration-result-page div.result")).getText(), "Your registration completed");

//        driver.findElement(By.cssSelector("a.ico-login")).click();

        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("button.login-button")).click();

        driver.findElement(By.cssSelector("a.ico-account")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddress);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), companyName);

//        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).getFirstSelectedOption().getText(), date);
//        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).getFirstSelectedOption().getText(), month);
//        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).getFirstSelectedOption().getText(), year);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddress);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), companyName);
    }

    // 3- Clean: delete data test/ account/ closed browser/ ...
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}
