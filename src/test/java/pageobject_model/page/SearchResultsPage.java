package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage extends  Pages{

    public void selectCompanyName() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().window(driver.getWindowHandle());
        WebElement companyNameInput = driver.findElement(By.cssSelector("input#jobsfilter-key_word"));
        Thread.sleep(3000);
        companyNameInput.sendKeys("Epam", Keys.RETURN);
        Thread.sleep(2000);
        List<WebElement> staffOffers = driver.findElements(By.xpath("//div/div/a[@class='load-more btn width100 job_load_more radius_changes']"));
        Thread.sleep(2000);
        staffOffers.get(0).click();
        Thread.sleep(2000);

    }
}
