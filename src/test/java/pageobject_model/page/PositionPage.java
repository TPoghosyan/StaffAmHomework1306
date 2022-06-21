package pageobject_model.page;

import org.openqa.selenium.By;

public class PositionPage extends Pages {
    public String getWebsiteText() {
        driver.switchTo().window(driver.getWindowHandle());
        System.out.println( driver.findElement(By.cssSelector("p a[href='https://www.epam.com/careers/epam-armenia']")).getText());
        return driver.findElement(By.cssSelector("p a[href='https://www.epam.com/careers/epam-armenia']")).getText();
    }

    public String getPhoneNumber() {
        return (driver.findElements(By.xpath("//p[@class='professional-skills-description']")).
                get(1).getText());
    }

    public String getCompanyAdress() {
        return (driver.findElements(By.xpath("//p[@class='professional-skills-description']")).
                get(2).getText());
    }
}
