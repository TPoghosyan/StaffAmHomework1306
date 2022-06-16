package pageobject_model.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject_model.page.StaffAmHomePage;

public class WEBStaffAmCategorySelectedTest extends  StaffAmTests{


    @Test(dataProvider = "staffAmCategories")
    public void staffAm(String categoryesName) throws InterruptedException {
        StaffAmHomePage staffAmHomePage = new StaffAmHomePage();

        Assert.assertTrue(staffAmHomePage.openPage()
                                         .chooseCategory(categoryesName)
                                         .clickSearchButton()
                                         .ElementIsChoosen());
    }



}
