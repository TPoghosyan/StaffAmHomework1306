package pageobject_model.page;

import org.openqa.selenium.By;

public class PositionPage extends Pages {
    public boolean checkMail(String email) {
        driver.switchTo().window(driver.getWindowHandle());
        return driver.findElement(By.cssSelector("p a[href='" + email + "']")).isEnabled();
    }

    public boolean checkPhone(String phoneNumber) {
        return (driver.findElements(By.xpath("//p[@class='professional-skills-description']")).
                get(1).getText().contains(phoneNumber));
    }

    public boolean checkAdress(String adress) {
        return (driver.findElements(By.xpath("//p[@class='professional-skills-description']")).
                get(2).getText().contains(adress));
    }
}
