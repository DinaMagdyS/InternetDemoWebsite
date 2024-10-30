package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;


    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        //driver.get("https://the-internet.herokuapp.com/");
        // homePage = new HomePage(driver);
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds());
        goHome();
        //setCookie();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    //@AfterClass
    //public void tearDown(){
      //  driver.quit();
    //}


    @AfterMethod
    /*
    public void takeScreenshot(){
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        System.out.println("Screenshot taken: "+ screenshot.getAbsolutePath());
        try{
            Files.move(screenshot,new File("resources/screenshots/test.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
     */
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/"+result.getName()+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }


/*   ---------Didn't Work-----
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }
 */
    /*
    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau","123")
                .domain("https://the-internet.herokuapp.com/")
                .build();
        driver.manage().addCookie(cookie);
    }

     */

}




//driver.manage().window().maximize();
//driver.manage().window().fullscreen();

//Dimension iphoneX = new Dimension(375,812);
//driver.manage().window().setSize(iphoneX);

//WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
//inputsLink.click();

//aaList<WebElement> links = driver.findElements(By.tagName("a"));
//System.out.println(links.size());


        /*
        driver.findElement(By.linkText("Shifting Content")).click();
        driver.findElement(By.linkText("Example 1: Menu Element")).click();
        List<WebElement> menuItems = driver.findElements(By.tagName("li"));
        System.out.println(menuItems.size());

         */


//System.out.println(driver.getTitle());