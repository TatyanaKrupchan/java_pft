package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void returnBackToGroupsTab() {
        click(By.linkText("group page"));
    }

    public void groupsTab() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("GROUPS"));
    }

    public void waitForRedirectionToMainPage() {
        WebDriverWait wait = new WebDriverWait(wd, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("MainForm")));
    }
}
