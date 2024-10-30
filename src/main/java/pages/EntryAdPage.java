package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntryAdPage {
    private WebDriver driver;
    private By modalText = By.cssSelector(".modal-body p");
    private By modalCancel = By.cssSelector(".modal-footer p");

    public EntryAdPage(WebDriver driver){
        this.driver = driver;
    }

    public String getModalText(){
       return driver.findElement(modalText).getText();
    }

    public void closeModal(){
        driver.findElement(modalCancel).click();
    }
}
