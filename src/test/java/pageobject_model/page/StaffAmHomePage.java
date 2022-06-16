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

    public StaffAmHomePage chooseSearchOption(String categoryesName) {
        categoryesName = "//*[contains(text(),'" + categoryesName + "')]";

        WebElement allCategories = driver.findElement(By.xpath(categoryesName));
        allCategories.click();

        WebElement searchButton = driver.findElement(By.xpath("//button[@type = 'submit'and@data-url='/en/site/search']"));
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(categoryesName + "/preceding-sibling::input")));
        this.categoryesName = categoryesName;
        return this;
    }

    public StaffAmHomePage chooseSearchOption(String categoryesName, String cityName) throws InterruptedException {
        categoryesName = "//*[contains(text(),'" + categoryesName + "')]";
        cityName = "//*[contains(text(),'" + cityName + "')]";
        WebElement allCategories = driver.findElement(By.xpath(categoryesName));
        allCategories.click();

        WebElement allCities = driver.findElement(By.xpath(cityName));
        allCities.click();

        Thread.sleep(2000);

        WebElement searchButton = driver.findElement(By.xpath("//button[@type = 'submit'and@data-url='/en/site/search']"));
        searchButton.click();
        this.cityName = cityName;
        return this;
    }

    public boolean ElementIsChoosen() {
        categoryesName = categoryesName + "/preceding-sibling::input";
        return (driver.findElement(By.xpath(categoryesName)).isSelected());

    }


}
