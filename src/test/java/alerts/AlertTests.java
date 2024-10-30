package alerts;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTest {

    @Test
    public void testAcceptAlert(){
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.triggerAlert();
        alertPage.alert_clickToAccept();
        assertEquals(alertPage.getResultText(),
                "You successfully clicked an alert",
                "Resulting Text Is Incorrect");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.triggerConfirm();
        String alertText = alertPage.alert_getText();
        alertPage.alert_clickToDismiss();
        assertEquals(alertText,
                "I am a JS Confirm",
                "Incorrect Alert Text");
    }


    @Test
    public void testSetInputInAlert(){
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.triggerPrompt();
        String text = "ITI Rocks!";
        alertPage.alert_setInput(text);
        alertPage.alert_clickToAccept();
        assertEquals("You entered: "+text,alertPage.getResultText(),"Incorrect Text");

    }
}
