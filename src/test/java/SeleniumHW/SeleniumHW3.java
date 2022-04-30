package SeleniumHW;
import Helper.MIsc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumHW3 {

    //verify correct temp displayed on Darksky

    @Test
    public void DarkSky() {
        MyDriver.launchUrlOnNewWindow("https://www.darksky.net");
        MyDriver.getDriver().manage().window().maximize();

        By TempElementLocator = By.xpath("//span[contains(text(),'58˚ Clear.')]");
        WebElement TempDisplay = MyDriver.getDriver().findElement(TempElementLocator);
        Assert.assertTrue(TempDisplay.isDisplayed());
    }
    //verify current date is displayed when landing on sign up form
    @Test
    public void FacebookTime() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com");
        By createNewAccountLocator = By.xpath("//a[text()='Create new account' or text()='Create New Account']");
        MyDriver.getDriver().findElement(createNewAccountLocator).click();

        MIsc.pause(5);

        By monthDdLocator = By.id("month");
        WebElement monthDdElement = MyDriver.getDriver().findElement(monthDdLocator);
        Select monthDd = new Select(monthDdElement);
        monthDd.selectByVisibleText("April");

        By dateDdLocator = By.name("birthday_day");
        WebElement dateDdElement = MyDriver.getDriver().findElement(dateDdLocator);
        Select dateDd = new Select(dateDdElement);
        dateDd.selectByValue("29");

        By yearDdLocator = By.xpath("//select[starts-with(@title, 'Ye')]");
        WebElement yearDdElement = MyDriver.getDriver().findElement(yearDdLocator);
        Select yearDd = new Select(yearDdElement);
        yearDd.selectByIndex(2022);

    }

    /**
     * TC-3: https://classroomessentialsonline.com/
     * Verify user lands on Economy Church Chairs page after clicking the option from Church Chairs
     */
    @Test
    public void ChurchChairsPage(){

        MyDriver.launchUrlOnNewWindow("https://www.classroomessentialsonline.com");
        By ChurchChairsLocator = By.xpath("//header/div[@id='menu']/nav[1]/ul[1]/li[1]/a[1]");
        WebElement ChurchChairs = MyDriver.getDriver().findElement(ChurchChairsLocator);
        Select EconomyChurchChairs = new Select(ChurchChairs);
        WebElement EconChurchChairs = MyDriver.getDriver().findElement(By.xpath("//a[contains(text(),'Economy Church Chairs')]"));
        Assert.assertTrue(EconChurchChairs.isDisplayed());
    }
}
