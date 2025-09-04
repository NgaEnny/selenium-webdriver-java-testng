package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.GregorianCalendar;

public class Topic_07_WebElement_Commands {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        driver.get("https://demo.nopcommerce.com");
    }

    // 2- Action/ Excute: Tương tác lên element nào/ nhập liệu/ verify/ ...
    @Test
    public void TC_01_WebElement() {
        // Dùng 1 lần
        driver.findElement(By.xpath("")).click(); //**

        WebElement element = driver.findElement(By.xpath(""));

        // Click vào các element dạng: button/ checkbox/ radio/ link/ image/ icon..
        element.click();

        // Nhập liệu các element dạng: textbox/ textarea/ dropdown (edit)
        element.clear(); // Xóa dữ liệu trước khi sendKey
        element.sendKeys("dam@gmail.com"); //**
        element.sendKeys(Keys.ENTER); //**

        driver.findElement(By.cssSelector("div.login-page"))
                .findElement(By.cssSelector("div.customer-blocks"))
                .findElement(By.id("Email"));

        driver.findElement(By.cssSelector("div.login-page div.customer-blocks input#Email"));

        // Tác dụng với form (SignUp/ Login/ Search/..)
        // thẻ form
        driver.findElement(By.id("Email")).sendKeys("");
        driver.findElement(By.id("Password")).sendKeys("");
        driver.findElement(By.id("Password")).submit();

        // Áp dụng cho tất cả các loại element
        // Kiểm tra 1 element có hiển thị hay không
        // Size > 0: width/height > 0
        // Nhìn thấy/ thao tác được
        element.isDisplayed(); //**

        Assert.assertTrue(element.isDisplayed());
        Assert.assertFalse(element.isDisplayed());

        // Áp dụng cho duy nhất 3 loại: checkbox/ radio/ dropdown (default)
        // Kiểm tra 1 element đã được chọn rồi hay chưa chọn
        element.isSelected(); //*

        // Áp dụng cho tất cả các loại
        // Kiểm tra 1 element có bị disable hay ko (read-only)
        element.isEnabled();

        element.getCssValue("background-color"); //*
        // #f82573

        // GUI: Font/ Size/ Color/ Position/ Location/..
        element.getCssValue("font-size");
        // 14px

        // Áp dụng cho element chứa text (Link/ Button/ Header/ Label/..)
        element.getText();

        element.getAttribute("placeholder"); //**
        // Search store

        Dimension dimensionBrowser = driver.manage().window().getSize();

        // Chiều rộng/ cao của element?
        Dimension dimensionElement = element.getSize();

        Point pointBrowser = (Point) driver.manage().window().getPosition();

        // Vị trí của element so với viewport
        element.getLocation();

        element.getRect();

        Rectangle rectangle = element.getRect();

        // Size
        rectangle.getWidth();
        rectangle.getHeight();
        rectangle.getDimension();

        // Location
        rectangle.getX();
        rectangle.getY();
        rectangle.getPoint();

        // Lấy ra cái thẻ html của element đó
        // Element A
        String tagname = driver.findElement(By.cssSelector("#FirstName")).getTagName();

        // Element B
        driver.findElement(By.xpath("//" + tagname + "[@id='LastName']"));

        element.getAccessibleName();

        element.getAriaRole();

        element.getDomAttribute("");

        element.getDomProperty(""); //*

        // Popup
        element.getShadowRoot();

        // Framework: HTML Report
        element.getScreenshotAs(OutputType.FILE); //*
        element.getScreenshotAs(OutputType.BYTES);
        element.getScreenshotAs(OutputType.BASE64);

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
