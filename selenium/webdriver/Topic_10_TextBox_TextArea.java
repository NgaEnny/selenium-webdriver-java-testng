package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Topic_10_TextBox_TextArea {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;
    WebDriverWait explicitWait;
    Random rand;
    String firstName, lastName, emailAddress, fullName, password, userName;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        rand = new Random();

        firstName = "Joe";
        lastName = "Biden";
        fullName = firstName + " " + lastName;
        emailAddress = "joebiden" + rand.nextInt(99999) + "@gmail.com";
        password = "123456789";
        userName = "ngaTest" + rand.nextInt(99999);
    }

    // 2- Action/ Excute: Tương tác lên element nào/ nhập liệu/ verify/ ...
    @Test
    public void TC_01_TechPanda() throws InterruptedException {
        driver.get("http://live.techpanda.org/index.php/");

        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);

        driver.findElement(By.cssSelector("button[title='Register']")).click();

        // Tuyệt đối
        Assert.assertEquals(
                driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Thank you for registering with Main Website Store.");

        String contactInformationText = driver.findElement(
                By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        System.out.println(contactInformationText);

        // Tương đối
        Assert.assertTrue(contactInformationText.contains(fullName) && contactInformationText.contains(emailAddress));

        driver.findElement(By.xpath("//h3[text()='Contact Information']/following-sibling::a")).click();

        Assert.assertEquals(driver.findElement(By.id("firstname")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.id("lastname")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value"), emailAddress);

        // Product Review
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//h2/a[@title='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();

        driver.findElement(By.cssSelector("input[id='Quality 1_5']")).click();

        driver.findElement(By.cssSelector("textarea#review_field"))
                .sendKeys("Good application\nPretty easy to navigate.");

        driver.findElement(By.cssSelector("input#summary_field")).sendKeys("Good Phone");

        driver.findElement(By.cssSelector("input#nickname_field")).clear();
        driver.findElement(By.cssSelector("input#nickname_field")).sendKeys("automationfc");

        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Your review has been accepted for moderation.");

        // Logout
        driver.findElement(By.cssSelector("div.account-cart-wrapper>a")).click();
        driver.findElement(By.xpath("//a[@title='Log Out']")).click();
        Thread.sleep(6000);

        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/");
    }

    @Test
    public void TC_02_OrangeHRM() throws InterruptedException {
        // Login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Click PIM > Add Employee
        driver.findElement(By.cssSelector("li>a[href*='/viewPim']")).click();

        driver.findElement(By.xpath("//a[contains(normalize-space(.), 'Add Employee')]")).click();

        // Input Employee (input First/LastName > get EmployeeID save > turn on Create Login Details
        // Nhập thông tin hợp lệ vào Username/ Password/ Confirm Password)

        driver.findElement(By.cssSelector("input[name=firstName]")).sendKeys("NgaQA");
        driver.findElement(By.cssSelector("input[name=lastName]")).sendKeys("Testing");
        WebElement employeeID = driver.findElement(By.xpath("//label[normalize-space()='Employee Id']/parent::div/following-sibling::div//input"));
        String empIdAdd = employeeID.getAttribute("value");

        // 1- Chờ loader biến mất (loading page after navigate)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.oxd-form-loader")));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.oxd-switch-input"))).click();

        driver.findElement(By.xpath("//label[normalize-space()='Username']/parent::div/following-sibling::div//input")).sendKeys(userName);
        driver.findElement(By.xpath("//label[normalize-space()='Password']/parent::div/following-sibling::div//input")).sendKeys("Test12345");
        driver.findElement(By.xpath("//label[normalize-space()='Confirm Password']/parent::div/following-sibling::div//input")).sendKeys("Test12345");

        // Save
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Verify dữ liệu đã nhp ở màn hình Add Employee đúng với dữ liệu ở Personal Detail
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name=firstName]")).getAttribute("value"), "NgaQA");
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name=lastName]")).getAttribute("value"), "Testing");
        Assert.assertEquals(driver.findElement(
                By.xpath("//label[normalize-space()='Employee Id']/parent::div/following-sibling::div//input")).getAttribute("value"), empIdAdd);

        // 8- Click vào tab Immigration
        driver.findElement(By.cssSelector("div>a[href*='/viewImmigration']")).click();

        // 9- Click Add tại Assigned Immigration
        driver.findElement(By.xpath("//h6[normalize-space()='Assigned Immigration Records']/following-sibling::button[contains(@class,'oxd-button--text')]")).click();

        // 10- Nhập value on Number/ Comments and Click Save button
        driver.findElement(By.xpath("//label[normalize-space()='Number']/ancestor::div[contains(@class,'oxd-input-group')]//input")).sendKeys("123456");
        driver.findElement(By.cssSelector("textarea.oxd-textarea")).sendKeys("Good");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // 11- Click on icon Pencil (Edit)

        // 12- Verify data đã tạo hiển thị đúng
        // 13- Click vào tên User và chọn Logout
        // 14- Tại màn hình Login nhập thông tin đã tạo trước đó
        // 15- Vào màn hình My Info
        // 16- Verify các thông tin hiển thị đúng: Firstname/ Lastname/ EmployeeID
        // 17- Vào màn hình Immigration > Click on icon Pencil (Edit)
        // 18- Verify thông tin hiển thị đúng

    }

    // 3- Clean: delete data test/ account/ closed browser/ ...
    @AfterClass
    public void cleanBrowser() {

        //driver.quit();
    }

}
