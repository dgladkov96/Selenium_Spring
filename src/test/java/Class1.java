import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Class1 {
    @Test //test annotation
    WebDriver driver = new ChromeDriver();

    public void launchAmazon{
        driver.get("https://www.amazon.com");


    }


}
