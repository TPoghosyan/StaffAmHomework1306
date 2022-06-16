import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class StaffAmTest2 {
    ChromeDriver driver;

    @Test(dataProvider = "staffAmCategories2")
    public void staffAm(String categoryesName, String cityName, String email, String phoneNumber, String adress) throws InterruptedException {
        categoryesName = "//*[contains(text(),'" + categoryesName + "')]";
        cityName = "//*[contains(text(),'" + cityName + "')]";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://staff.am/");

        WebElement allCategories = driver.findElement(By.xpath(categoryesName));
        allCategories.click();

        WebElement allCities = driver.findElement(By.xpath(cityName));
        allCities.click();

        Thread.sleep(2000);

        WebElement searchButton = driver.findElement(By.xpath("//button[@type = 'submit'and@data-url='/en/site/search']"));
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(categoryesName + "/preceding-sibling::input")));

        driver.switchTo().window(driver.getWindowHandle());
        WebElement companyNameInput = driver.findElement(By.cssSelector("input#jobsfilter-key_word"));
        Thread.sleep(3000);
        companyNameInput.sendKeys("Epam", Keys.RETURN);

        Thread.sleep(2000);

        List<WebElement> staffOffers = driver.findElements(By.xpath("//div/div/a[@class='load-more btn width100 job_load_more radius_changes']"));
        Thread.sleep(2000);
        staffOffers.get(0).click();

        Thread.sleep(2000);

        driver.switchTo().window(driver.getWindowHandle());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.cssSelector("p a[href='" + email + "']")).isEnabled());
        softAssert.assertTrue((driver.findElements(By.xpath("//p[@class='professional-skills-description']")).
                                                get(1).getText().contains(phoneNumber)));
        softAssert.assertTrue((driver.findElements(By.xpath("//p[@class='professional-skills-description']")).
                                                get(2).getText().contains(adress)));


        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        //  driver.close();
        //driver.quit();
    }

    @DataProvider
    public Object[][] staffAmCategories2() {
        return new Object[][]{
                {"IT Support/Technician", "Yerevan", "https://www.epam.com/careers/epam-armenia","+37410600065","15 Khorenatsi Street"},
                //     {"Finance Management"},
                //  {"Other IT"},
                //{"tikooooo@rambler.ru"},
        };
    }
}

