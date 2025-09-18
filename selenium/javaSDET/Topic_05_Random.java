package javaSDET;

import org.testng.annotations.Test;

import java.util.Random;

public class Topic_05_Random {

    String preFixEmail = "joebiden";
    String postFixEmail = "@gmail.com";

    String fullEmail = preFixEmail + preFixEmail;

    @Test
    public  void testEmail() {
        Random rand = new Random();

        // Local
        String fullEmail = preFixEmail + rand.nextInt(999999) + postFixEmail;
        String fullEmail1 = preFixEmail + rand.nextInt(999999) + postFixEmail;
        String fullEmail2 = preFixEmail + rand.nextInt(999999) + postFixEmail;
        String fullEmail3 = preFixEmail + rand.nextInt(999999) + postFixEmail;
        System.out.println(fullEmail);
        System.out.println(fullEmail1);
        System.out.println(fullEmail2);
        System.out.println(fullEmail3);
    }
}
