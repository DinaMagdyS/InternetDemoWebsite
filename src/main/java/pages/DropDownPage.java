package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropDownPage {
    private WebDriver driver;
    private By dropdown = By.id("dropdown");


    public DropDownPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectFromDropDown(String option){
        //Select dropdownElement = new Select(driver.findElement(dropdown));
        //dropdownElement.selectByVisibleText(option);
        findDropDownElement().selectByVisibleText(option);
    }

    //Get Selected Options Into A List

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements =
                findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    //Multiple Attributes
    public void addMultipleAttribute(){
        findDropDownElement();
        String script = "arguments[0].setAttribute('multiple', '')";
        ((JavascriptExecutor)driver).executeScript(script, findDropDownElement());
    }
    private Select findDropDownElement(){
        return new Select(driver.findElement(dropdown));
    }



}
