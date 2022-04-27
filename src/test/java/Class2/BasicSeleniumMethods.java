package Class2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicSeleniumMethods {
    @Test
    public void basicMethods() {

        // path of chromedriver
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        /**
         *  WebDriver is an Interface
         *  ChromeDriver/FirefoxDriver is a Class (which is related to WebDriver Interface)
         *
         *  WebDriver driver -> driver is a variable of WebDriver Interface
         *  new ChromeDriver() -> object of ChromeDriver class
         *
         *  WebDriver driver = new ChromeDriver();
         *  Storing ChromeDriver-object into WebDriver-variable.
         *
         *  ChromeDriver(C) extends RemoteWebDriver(C) ; RemoteWebDriver(C) implements WebDriver(I)
         *
         */

        /**
         * To launch a webpage
         *
         * Method-1 : get()
         *
         * Method-2 : navigate().to()
         */
        String url = "https://www.facebook.com/";
        driver.get(url);
        //      OR
        // driver.navigate().to(url);
        /**
         * get() vs navigate().to()
         *
         * get() -> launches the webpage and wait for few seconds (for webpage to load)
         *          before executing the next line in the code
         *
         * navigate().to() -> launches the webpage
         *          and goes to execute the next line in the code
         */

        // Sleep so that webpage loads completely (temporary solution)
        try {
            Thread.sleep(5000);     // sleep for 5-seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * Method to maximize the webpage
         *
         * method: maximize()
         */
        // driver.manage().window().maximize();

        /**
         * To get the url from browser-window
         *
         * method: getCurrentUrl()
         * Return type: String
         */
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current url -> " + currentUrl);

        /**
         * To get page title of the webpage
         *
         * method: getTitle()
         */
        String pageTitle = driver.getTitle();
        System.out.println("Page title -> " + pageTitle);

        /**
         * To back/forward in a web-browser
         *
         * method : back()
         * method : forward()
         */
        driver.navigate().back();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Page title -> " + driver.getTitle());

        driver.navigate().forward();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Page title -> " + driver.getTitle());


        /**
         * To refresh a webpage
         *
         * Method-1: click refresh-icon (method: refresh())
         *
         * Method-2: go back then forward
         *
         * Method-3: Launch the current url
         *
         */
        // 1
        driver.navigate().refresh();

        // 2
        driver.navigate().back();
        driver.navigate().forward();

        // 3
        /*
            1. get the current url  (getCurrentUrl)
            2. launch the url got from step-1 (get)
         */
        String myUrl = driver.getCurrentUrl();
        driver.get(myUrl);

        /**
         * To close a webpage
         *
         * Method-1 : close()
         *      will close ONLY web-window associated/connected with driver
         *
         *
         * Method-2 : quit()
         *      will close ALL web-windows opened due to automation code/script
         */
        // driver.close();
    }

    // Verify correct url is launch
    /*
        Open a browser window
        Launch facebook.com
        verify currentUrl is facebook.com

     */
    @Test
    public void verifyCorrectUrl() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        String url = "https://www.facebook.com/";
        driver.get(url);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(url, currentUrl, "Current url is NOT same as launched url");


    }





}

}
