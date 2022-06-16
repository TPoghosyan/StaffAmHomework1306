package pageobject_model.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobject_model.page.PositionPage;
import pageobject_model.page.SearchResultsPage;
import pageobject_model.page.StaffAmHomePage;

public class WebStaffAmCompanysTest extends StaffAmTests {

    @Test(dataProvider = "staffAmCategoriesAndCityes")
    public void staffAm(String category,String city) throws InterruptedException {
        StaffAmHomePage staffAmHomePage = new StaffAmHomePage();

        staffAmHomePage.openPage()
                       .chooseCategory(category)
                       .chooseCity(city)
                       .clickSearchButton();

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.selectCompanyName();

        PositionPage positionPage = new PositionPage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(positionPage.checkMail("https://www.epam.com/careers/epam-armenia"));
        softAssert.assertTrue(positionPage.checkPhone("+37410600065"));
        softAssert.assertTrue(positionPage.checkAdress("15 Khorenatsi Street"));
        softAssert.assertAll();
    }
}
