package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StaffAmHomePage extends Pages {

    public static String categoryesName;
    public static String cityName;

    public StaffAmHomePage openPage() {
        driver = new ChromeDriver();
        driver.get("https://staff.am/");
        return this;
    }

    public StaffAmHomePage chooseCategory(String categoryesName) {
        categoryesName = "//*[contains(text(),'" + categoryesName + "')]";

        WebElement allCategories = driver.findElement(By.xpath(categoryesName));
        allCategories.click();
        StaffAmHomePage.categoryesName =categoryesName;
        return this;
    }


    public SearchResultsPage clickSearchButton() {
        WebElement searchButton = driver.findElement(By.xpath("//button[@type = 'submit'and@data-url='/en/site/search']"));
        searchButton.click();
        return new SearchResultsPage();

    }

    public StaffAmHomePage chooseCity(String cityName) throws InterruptedException {
        cityName = "//*[contains(text(),'" + cityName + "')]";

        WebElement allCities = driver.findElement(By.xpath(cityName));
        allCities.click();

        Thread.sleep(2000);
        this.cityName = cityName;
        return this;
    }




}
