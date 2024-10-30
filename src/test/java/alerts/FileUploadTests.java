package alerts;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTest {

    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\Users\\SONY\\Downloads\\SeleniumWebdriverTAU\\resources\\chromedriver.exe");
        assertEquals(uploadPage.getUploadedFiles(),"chromedriver.exe","Incorrect Filename");
    }

}
