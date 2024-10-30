package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InternalServerErrorPage {
    private WebDriver driver;
    private By serverErrorTitle = By.xpath("//*[text() = 'Internal Server Error']");

    public InternalServerErrorPage(WebDriver driver){
        this.driver = driver;
    }
    public String getDisplayedText(){
        return driver.findElement(serverErrorTitle).getText();


    }

}
