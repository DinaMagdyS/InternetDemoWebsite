package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;

    private By emailField = By.id("email");
    private By retrievePasswordButton = By.cssSelector("#content button");

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public InternalServerErrorPage clickRetrievePasswordButton(){
        driver.findElement(retrievePasswordButton).click();
        return new InternalServerErrorPage(driver);
    }
}
