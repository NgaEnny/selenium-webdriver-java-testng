package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;

    // Biến
    // Access Modifier - Kiểu dữ liệu - Tên biến - Giá trị của biến
    private  String fullName = "Automation Testing";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        driver.get("https://demo.nopcommerce.com/login");
    }

    // 2- Action/ Excute: Tương tác lên element nào/ nhập liệu/ verify/ ...
    @Test
    public void TC_01_ID() throws InterruptedException {
        // Tương tác lên Email textbox
        // <input class="email" autofocus="" type="email" data-val="true" data-val-regex="Wrong email"
        // data-val-required="Please enter your email"
        // id="Email" name="Email">

        // HTML Source Code
        // Thẻ - Thuộc tính - giá trị thuộc tính
        // Tagname - Attribute - Value

        // Xpath: //tagname[@attribute='value']
        // Css: tagname[attribute]

        // Tuong tac len Email Address textbox
        // 8 loai locator để tìm Email Address này

        // Sau dấu . gọi hàm/ biến của thư viện

        // Tìm 1 element
        driver.findElement(By.id("small-searchterms")).sendKeys("Macbook");
        Thread.sleep(3000);

        // 1- Thao tác lên luôn (dùng 1 lần)
//        driver.findElement(By.id("")).click();
//
//        // 2-  Lưu dữ liệu lại (dùng nhiều lần)
//        WebElement emailTextbox = driver.findElement(By.id(""));
//        emailTextbox.clear();
//        emailTextbox.sendKeys("");
//        emailTextbox.isDisplayed();
//
//        //Tìm nhiều element giống nhau
//        driver.findElement(By.cssSelector("")).click();
//        driver.findElement(By.cssSelector("")).getText()

        driver.findElement(By.id("FirstName"));
        Thread.sleep(3000);

    }

    @Test
    public void TC_02_Class() throws InterruptedException {
        // Nó ko lấy hết toàn bọ giá trị (nếu có khoảng trắng)
        driver.findElement(By.className("register-button")).click();
        Thread.sleep(3000);
    }

    @Test
    public void TC_03_Name() {
//        driver.findElement(By.name("DateOfBirthDay"));
        driver.findElement(By.name("DateOfBirthMonth"));
        driver.findElement(By.name("DateOfBirthYear"));
    }

    @Test
    public void TC_04_LinkText() {
        // Chỉ làm việc với element là link và có text
        // Thẻ a và có thuộc tính href
        driver.findElement(By.linkText("Register"));
        driver.findElement(By.linkText("Log in"));
    }

    @Test
    public void TC_05_Partial_Link_Text() {
    //Chỉ làm việc với element là lin
    // có thể lấy toàn bộ text hoặc 1 phần
        driver.findElement(By.partialLinkText("Register"));

        driver.findElement(By.partialLinkText("Digital"));

        driver.findElement(By.partialLinkText("downloads"));
    }

    @Test
    public void TC_06_TagName() {

        // Tìm thẻ (html)
        // Tim tất cả textbox, test e
        // Tìm cả các textbox. checkbox/ raido/ link/ button/...
        driver.findElements(By.tagName("button"));

        driver.findElements(By.tagName("input"));

        driver.findElements(By.tagName("label"));
    }
    @Test
    public void TC_07_Css() {
        //
        driver.findElement(By.cssSelector("input#Company"));
        driver.findElement(By.cssSelector("#Company"));
        driver.findElement(By.cssSelector("input[id=Company]"));

        driver.findElement(By.cssSelector("button.register-next-step-button"));
        driver.findElement(By.cssSelector("button[class='button-1 register-next-step-button']"));

        driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"));
        driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"));
        driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"));

        driver.findElement(By.cssSelector("a[href*='/register?returnUrl=%2Fregister']"));
        driver.findElement(By.cssSelector("a[href*='/login?returnUrl=%2Fregister']"));

        driver.findElement(By.cssSelector("a[href*='register?']"));
        driver.findElement(By.cssSelector("a[href*='login?']"));

        driver.findElement(By.cssSelector("a"));
        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("input"));
    }

    @Test
    public void TC_08_XPath() {
        //
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        driver.findElement(By.xpath("//input[@id='Password']"));
        driver.findElement(By.xpath("//input[@id='Company']"));

        driver.findElement(By.xpath("//button[@class='button-1 register-next-step-button"));
        driver.findElement(By.xpath("//button[contains(@class, 'register-next-step-button"));

        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));

        driver.findElement(By.xpath("//a[text()='Register']"));
        driver.findElement(By.xpath("//a[text()='Log in']"));
        driver.findElement(By.xpath("//a[text()='Shipping & returns']"));

        driver.findElement(By.xpath("//a[contains(text(), 'Register"));
        driver.findElement(By.xpath("//a[contains(text(), 'Shipping"));
        driver.findElement(By.xpath("//a[contains(text(), '& return"));

        driver.findElement(By.xpath("//a"));
        driver.findElement(By.xpath("//button"));
        driver.findElement(By.xpath("//input"));

    }

    // 3- Clean: delete data test/ account/ closed browser/ ...
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}
