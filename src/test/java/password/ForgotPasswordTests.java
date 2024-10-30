package password;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.InternalServerErrorPage;

import static org.testng.Assert.assertTrue;

public class ForgotPasswordTests extends BaseTest {

    @Test
    public void testRetrievePassword(){

        var forgotpasswordPage = homePage.clickForgotPassword();
        forgotpasswordPage.setEmailField("angiejones@yahoo.com");
        var errorPage = forgotpasswordPage.clickRetrievePasswordButton();
        assertTrue(errorPage.getDisplayedText().
                contains("Server Error"),
                "Message is incorrect");

    }
}
