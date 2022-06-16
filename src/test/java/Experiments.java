import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class Experiments {
    ChromeDriver driver;

    @Test(dataProvider = "staffAmCategories2")
    public void staffAm(String categoryesName, String cityName, String email) throws InterruptedException {
//            categoryesName = "//*[contains(text(),'" + categoryesName + "')]";
//            cityName = "//*[contains(text(),'" + cityName + "')]";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://staff.am/en/cloud-devops-team-leadmanager-33");

//            WebElement allCategories = driver.findElement(By.xpath(categoryesName));
//            allCategories.click();
//
//
//            WebElement allCities = driver.findElement(By.xpath(cityName));
//            allCities.click();
//
//            Thread.sleep(2000);

//
//        List<WebElement> x = driver.findElements(By.xpath("//p[@class='professional-skills-description']"));
//        System.out.println(x.get(1).getText());
        System.out.println((driver.findElements(By.xpath("//p[@class='professional-skills-description']")).
                get(1).getText().contains("+37410600065")));
//        softAssert.assertTrue(driver.findElement(By.cssSelector("p a[href='"+email+"']")).isEnabled());
//        softAssert.assertTrue(driver.findElement(By.cssSelector("p a[href='"+email+"']")).isEnabled());

        //  softAssert.assertAll();
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
                {"IT Support/Technician", "Yerevan", "https://www.epam.com/careers/epam-armenia"},
                //     {"Finance Management"},
                //  {"Other IT"},
                //{"tikooooo@rambler.ru"},
        };
    }
}



