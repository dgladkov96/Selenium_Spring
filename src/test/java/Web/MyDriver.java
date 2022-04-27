package Web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriver {

    private static WebDriver driver;

    public static void launchUrlOnNewWindow(String url) {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        driver = new ChromeDriver();

        driver.get(url);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            driver.quit();
        }
    }

    public static void quitWindows() {
        driver.quit();
    }
    public static WebDriver getDriver() {
        return driver;

    }
}
