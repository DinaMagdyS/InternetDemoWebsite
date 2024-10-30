package modal;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EntryAdTests  extends BaseTest {

    @Test
    public void testModal() throws InterruptedException {
        var entryPage = homePage.clickEntryAd();
        Thread.sleep(4000);
        assertEquals(entryPage.getModalText(),
                "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker).",
                "Incorrect Model Body");
        entryPage.closeModal();
    }
}
