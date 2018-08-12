package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void returnToHomePage() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void returnBackToGroupsTab() {
        wd.findElement(By.linkText("group page")).click();
    }

    public void gotoGroupsTab() {
        wd.findElement(By.linkText("GROUPS")).click();
    }
}
