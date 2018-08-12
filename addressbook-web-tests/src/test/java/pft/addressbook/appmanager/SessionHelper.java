package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void login(String login, String password) {
        fillAField("user", login);
        fillAField("pass", password);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
        // wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

}
