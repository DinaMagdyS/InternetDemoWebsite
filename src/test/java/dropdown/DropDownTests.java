package dropdown;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DropDownPage;

import static org.testng.Assert.*;

public class DropDownTests extends BaseTest {


    @Test
    public void testSelectOption(){
        var dropDownPage =  homePage.clickDropDown();
        String option = "Option 1";
        dropDownPage.selectFromDropDown(option);
        var selectedOptions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1,"Incorrect Number of Selections");
        assertTrue(selectedOptions.contains(option),"Option not Selected");

    }


}
