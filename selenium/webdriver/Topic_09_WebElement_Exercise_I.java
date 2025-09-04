package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_WebElement_Exercise_I {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

    }

    // 2- Action/ Excute: Tương tác lên element nào/ nhập liệu/ verify/ ...
    @Test
    public void TC_01_isDisplayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));

        if (emailTextbox.isDisplayed()) {
            System.out.println("Email Textbox is displayed");
            emailTextbox.sendKeys("Automation Testing");
        } else {
            System.out.println("Email Textbox is not displayed");
        }

        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
        if (ageUnder18Radio.isDisplayed()) {
            System.out.println("Under 18 Age is displayed");
            ageUnder18Radio.click();
        } else {
            System.out.println("Under 18 Age is not displayed");
        }

        WebElement eduTextbox = driver.findElement(By.cssSelector("textarea#edu"));
        if (eduTextbox.isDisplayed()) {
            System.out.println("Education Textbox is displayed");
            eduTextbox.sendKeys("IT");
        } else {
            System.out.println("Education Textbox is not displayed");
        }

        WebElement user5Text = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
        if (user5Text.isDisplayed()) {
            System.out.println("User 05 Text is displayed");
        } else {
            System.out.println("User 05 Text is not displayed");
        }
    }

    @Test
    public void TC_02_isEnabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));
        if (emailTextbox.isEnabled()) {
            System.out.println("Email Textbox is enabled");
            emailTextbox.sendKeys("Automation Testing");
        } else {
            System.out.println("Email Textbox is not enabled");
        }

        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
        if (ageUnder18Radio.isEnabled()) {
            System.out.println("Under 18 Age is enabled");
            ageUnder18Radio.click();
        } else {
            System.out.println("Under 18 Age is not enabled");
        }

        WebElement eduTextbox = driver.findElement(By.cssSelector("textarea#edu"));
        if (eduTextbox.isEnabled()) {
            System.out.println("Education Textbox is enabled");
            eduTextbox.sendKeys("IT");
        } else {
            System.out.println("Education Textbox is not enabled");
        }

        WebElement passTextArea = driver.findElement(By.cssSelector("input#password"));
        if (passTextArea.isEnabled()) {
            System.out.println("Password Textbox is enabled");
        } else {
            System.out.println("Password Textbox is not enabled");
        }

        WebElement jobRole1TextArea = driver.findElement(By.cssSelector("select#job1"));
        if (jobRole1TextArea.isEnabled()) {
            System.out.println("Job Role 1 TextArea is enabled");
        } else {
            System.out.println("Job Role 1 TextArea is not enabled");
        }

        WebElement jobRole2TextArea = driver.findElement(By.cssSelector("select#job2"));
        if (jobRole1TextArea.isEnabled()) {
            System.out.println("Job Role 2 TextArea is enabled");
        } else {
            System.out.println("Job Role 2 TextArea is not enabled");
        }

        WebElement interestChecbox = driver.findElement(By.cssSelector("input#development"));
        if (interestChecbox.isEnabled()) {
            System.out.println("Interests Development checkbox is enabled");
            interestChecbox.click();
        } else {
            System.out.println("Interests Development checkbox is not enabled");
        }

        WebElement slider01 = driver.findElement(By.cssSelector("input#slider-1"));
        if (slider01.isEnabled()) {
            System.out.println("Slider 01 is enabled");
            slider01.click();
        } else {
            System.out.println("Slider 01 is not enabled");
        }

        // Verify element is disabled
        WebElement passDisabledTextArea = driver.findElement(By.cssSelector("input#disable_password"));
        if (passDisabledTextArea.isEnabled()) {
            System.out.println("Password Disabled Textbox is enabled");
        } else {
            System.out.println("Password Disabled Textbox is not enabled");
        }

        WebElement ageRadioButtonDisabled = driver.findElement(By.cssSelector("input#radio-disabled"));
        if (ageRadioButtonDisabled.isEnabled()) {
            System.out.println("Radio button is disable radio is enabled");
            ageRadioButtonDisabled.click();
        } else {
            System.out.println("Radio button is disable radio is not enabled");
        }

        WebElement biographyTextArea = driver.findElement(By.cssSelector("textarea#bio"));
        if (biographyTextArea.isEnabled()) {
            System.out.println("Biography TextArea is enabled");
        } else {
            System.out.println("Biography TextArea is not enabled");
        }

        WebElement selectJob3 = driver.findElement(By.cssSelector("select#job3"));
        if (selectJob3.isEnabled()) {
            System.out.println("Select Job3 is enabled");
        } else {
            System.out.println("Select Job3 is not enabled");
        }

        WebElement interestsCheckboxDisabled = driver.findElement(By.cssSelector("input#check-disbaled"));
        if (interestsCheckboxDisabled.isEnabled()) {
            System.out.println("Interests checkbox disabled is enabled");
        } else {
            System.out.println("Interests checkbox disabled is not enabled");
        }

        WebElement slider02 = driver.findElement(By.cssSelector("input#slider-2"));
        if (slider02.isEnabled()) {
            System.out.println("Slider 02 is enabled");
            slider02.click();
        } else {
            System.out.println("Slider 02 is not enabled");
        }
    }

    @Test
    public void TC_03_isSelected() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
        ageUnder18Radio.click();
        if (ageUnder18Radio.isSelected()) {
            System.out.println("Under 18 Age is selected");
        } else {
            System.out.println("Under 18 Age is de-selected");
        }

        WebElement languageJavaCheckbox = driver.findElement(By.cssSelector("input#java"));
        if (languageJavaCheckbox.isSelected()) {
            System.out.println("Language Java Checkbox is selected");
        } else {
            System.out.println("Language Java Checkbox is de-selected");
        }

        WebElement languageCCheckbox = driver.findElement(By.xpath("//input[@id='c#']"));
        languageCCheckbox.click();
        if (languageCCheckbox.isSelected()) {
            System.out.println("Language C# Checkbox is selected");
            languageCCheckbox.click();
        } else {
            System.out.println("Language C# Checkbox is de-selected");
        }

        WebElement languageJavascriptCheckbox = driver.findElement(By.cssSelector("input#javascript"));
        if (languageJavascriptCheckbox.isSelected()) {
            System.out.println("Language Javascript Checkbox is selected");
            languageJavascriptCheckbox.click();
        } else {
            System.out.println("Language Javascript Checkbox is de-selected");
        }

        WebElement languagePythonCheckbox = driver.findElement(By.cssSelector("input#python"));
        if (languagePythonCheckbox.isSelected()) {
            System.out.println("Language Python Checkbox is selected");
            languagePythonCheckbox.click();
        } else {
            System.out.println("Language Python Checkbox is de-selected");
        }

        WebElement languageRubyCheckbox = driver.findElement(By.cssSelector("input#Ruby"));
        if (languageRubyCheckbox.isSelected()) {
            System.out.println("Language Ruby Checkbox is selected");
            languageRubyCheckbox.click();
        } else {
            System.out.println("Language Ruby Checkbox is de-selected");
        }

        WebElement languagePHPCheckbox = driver.findElement(By.cssSelector("input#PHP"));
        if (languagePHPCheckbox.isSelected()) {
            System.out.println("Language PHP Checkbox is selected");
            languagePHPCheckbox.click();
        } else {
            System.out.println("Language PHP Checkbox is de-selected");
        }
    }

    @Test
    public void TC_04_MailChimp_Register_Validate() throws InterruptedException {
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.cssSelector("input#email")).sendKeys("bichnga@gmail.com");
        driver.findElement(By.cssSelector("input#email")).sendKeys(Keys.TAB);

        driver.findElement(By.cssSelector("input#new_username")).sendKeys("bichnga@gmail.com");
        driver.findElement(By.cssSelector("input#new_username")).sendKeys(Keys.TAB);

        // Input number
        driver.findElement(By.id("new_password")).sendKeys("12345");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // Input lower text
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("Testing");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // Input upper text
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("TESTING");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // Input special chars
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("!@#$");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // Input Contains Username
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("bichnga");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());

        // Input all valid value
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("Test123!@#");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);

        Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
    }
    // 3- Clean: delete data test/ account/ closed browser/ ...
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}
