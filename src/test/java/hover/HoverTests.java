package hover;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class HoverTests extends BaseTest {

    @Test
    public void testHoverUser1(){
        var hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(),"Caption not displayed");
        assertEquals(caption.getTitle(),"name: user1","Caption Title Incorrect");
        assertEquals(caption.getLinkText(),"View profile","Caption Link Text Incorrect");
        assertTrue(caption.getLink().endsWith("/users/1"), "Link Incorrect");
    }
}
