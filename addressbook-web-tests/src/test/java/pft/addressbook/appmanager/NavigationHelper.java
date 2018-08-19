package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver wd;

    public NavigationHelper(WebDriver wd) {
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
