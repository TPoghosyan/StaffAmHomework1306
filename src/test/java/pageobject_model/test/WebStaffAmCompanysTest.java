package pageobject_model.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobject_model.page.PositionPage;
import pageobject_model.page.StaffAmHomePage;

public class WebStaffAmCompanysTest extends StaffAmTests {

    @Test(dataProvider = "staffAmCategoriesAndCityes")
    public void staffAm(String category, String city) throws InterruptedException {
        StaffAmHomePage staffAmHomePage = new StaffAmHomePage();

        PositionPage positionPage = staffAmHomePage.openPage()
                .chooseCategory(category)
                .chooseCity(city)
                .clickSearchButton()
                .selectCompanyName("Epam");


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(positionPage.getWebsiteText(), "https://www.epam.com/careers/epam-armenia");
        softAssert.assertTrue(positionPage.getPhoneNumber("+37410600065"));
        softAssert.assertTrue(positionPage.getCompanyAdress("15 Khorenatsi Street"));
        softAssert.assertAll();
    }
}
