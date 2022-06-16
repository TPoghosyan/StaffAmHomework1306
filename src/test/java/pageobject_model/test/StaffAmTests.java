package pageobject_model.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import pageobject_model.page.Pages;

public class StaffAmTests {

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        Pages.driver.close();
        Pages.driver.quit();
    }


    @DataProvider
    public Object[][] staffAmCategories() {
        return new Object[][]{
                {"Hardware design"},
                //     {"Finance Management"},
                //  {"Other IT"},
                //  {"tikooooo@rambler.ru"},
        };
    }

    @DataProvider
    public Object[][] staffAmCategoriesAndCityes() {
        return new Object[][]{
                {"IT Support/Technician", "Yerevan"},
                //     {"Finance Management","Goris"},

        };
    }
}
