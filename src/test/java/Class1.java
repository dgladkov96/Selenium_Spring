import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Class1 {


    @Test
    public void LaunchAmazon(){

        //path of chromedriver
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");


        WebDriver driver = new ChromeDriver();
        String amazonURL = "https://www.amazon.com";
        driver.get(amazonURL);



    }



}
