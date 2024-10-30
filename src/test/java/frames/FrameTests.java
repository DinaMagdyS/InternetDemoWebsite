package frames;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTest {

    @Test
    public void testWysiwyg(){
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();
        String text1 = "Hello";
        String text2 = "Worldoo";
        editorPage.setTextArea(text1);
        editorPage.decreaseIndentation();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromEditor(),
                text1+text2,
                "Incorrect Text");
    }
}
