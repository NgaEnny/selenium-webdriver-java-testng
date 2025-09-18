package javaSDET;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_04_And_Or {

    @Test
    public void verifyAnd() {
        String contactInformation = "Testing Automation\n" +
                "automationfc1562024@gmail.com\n" +
                "Change Password";

        Assert.assertTrue(contactInformation.contains("Testing Automation")
                && contactInformation.contains("automationfc1562024@gmail.com"));
    }
}