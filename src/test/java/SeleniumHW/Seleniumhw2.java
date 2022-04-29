package SeleniumHW;
import Helper.MIsc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.Signed;

public class Seleniumhw2 {
    /**
     * Testcase-1:
     *
     *
     * Verify "Keep me signed in" is NOT selected for messenger login page
     *
     * Click "Log in" button
     *
     * Verify "Incorrect email or phone number" is displayed
     *
     * Verify "Continue" button is enabled
     *
     *
     * @return
     */
    @Test

    public void verifyKeepmeSignedIn() {
        MyDriver.launchUrlOnNewWindow("https://facebook.com");

        String messengerText = "Messenger";
        By messengerLocator = By.linkText(messengerText);
        WebElement messengerLink = MyDriver.getDriver().findElement(messengerLocator);

        String hrefValue = messengerLink.getAttribute("href");
        Assert.assertTrue(hrefValue.contains("messenger.com"));

        messengerLink.click();
        MIsc.pause(5);
        String urlAfterLink = MyDriver.getDriver().getCurrentUrl();
        Assert.assertTrue(urlAfterLink.contains("messenger.com"), "Url is incorrect");


        By SignedinBoxLocator = By.xpath("//label[contains(text(),'Keep me signed in')]");
        WebElement SignedInBox = MyDriver.getDriver().findElement(By.xpath("//input[@id='Keep me signed in]"));
        Assert.assertTrue(SignedInBox.isSelected());
        WebElement Login = MyDriver.getDriver().findElement(By.id("u_0_v"));
        Login.click();

        By IncorrectEmailLocator = By.id("Incorrect email or phone number");
        WebElement IncorrectEmail = MyDriver.getDriver().findElement(IncorrectEmailLocator);
        Assert.assertTrue(IncorrectEmail.isDisplayed(), "Incorrect Email is not displayed");

        By ContinueButtonLocator = By.id("loginbutton");
        WebElement ContinueButton = MyDriver.getDriver().findElement(ContinueButtonLocator);
        Assert.assertTrue(ContinueButton.isEnabled());


        MyDriver.quitWindows();

    }


    /**
     * Testcase-2:
     * On Create new account page:
     *
     * Verify the "Sign Up" button is enabled when user lands on the form
     *
     * Enter the below details in Sign Up form EXCEPT DOB
     * First name
     * Last name
     * email
     * re-enter email
     * new password
     * click Sign Up
     *
     * Verify "Please choose a gender. You can change who can see this later." is displayed
     *
     */

    public void createAccount() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com");
        By signupButtonLocator = By.id("Sign Up for Facebook");
        WebElement signUpButton = MyDriver.getDriver().findElement(signupButtonLocator);
        Assert.assertTrue(signUpButton.isEnabled());

        signUpButton.click();
        MyDriver.getDriver().findElement(By.name("firstname")).sendKeys("Daniil");
        MyDriver.getDriver().findElement(By.name("lastname")).sendKeys("Gladkov");
        MyDriver.getDriver().findElement(By.id("u_0_o_3B")).sendKeys("daniilg1996@gmail.com");
        MyDriver.getDriver().findElement(By.id("password_step_input")).sendKeys("newPassword12345");

        WebElement MaleGender = MyDriver.getDriver().findElement(By.xpath("//input[@id='u_0_5_8t']"));
        MaleGender.click();
        MyDriver.getDriver().findElement(By.name("websubmit")).click();

        WebElement PleaseChoosegender = MyDriver.getDriver().findElement(By.id("js_8x"));
        Assert.assertTrue(PleaseChoosegender.isDisplayed());

        MyDriver.quitWindows();







    }



}
