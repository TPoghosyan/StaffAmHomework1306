import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class StaffAmTest1 {
    ChromeDriver driver;

    @Test(dataProvider = "staffAmCategories")
    public void staffAm(String categoryesName) throws InterruptedException {
        categoryesName = "//*[contains(text(),'" + categoryesName + "')]";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://staff.am/");

        WebElement allCategories = driver.findElement(By.xpath(categoryesName));
        allCategories.click();

        WebElement searchButton = driver.findElement(By.xpath("//button[@type = 'submit'and@data-url='/en/site/search']"));
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(categoryesName + "/preceding-sibling::input")));

        categoryesName = categoryesName + "/preceding-sibling::input";

        Assert.assertTrue(driver.findElement(By.xpath(categoryesName)).isSelected());

    }




}

