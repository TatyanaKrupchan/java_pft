package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelperBase {

    FirefoxDriver wd;

    public HelperBase(FirefoxDriver wd) {
        this.wd = wd;
    }

    protected void fillAField(String fieldName, String fieldValue) {
        click(By.name(fieldName));
        clearElement(By.name(fieldName));
        insertValue(fieldName, fieldValue);
    }

    protected void insertValue(String fieldName, String fieldValue) {
        wd.findElement(By.name(fieldName)).sendKeys(fieldValue);
    }

    protected void clearElement(By locator) {
        wd.findElement(locator).clear();
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}
