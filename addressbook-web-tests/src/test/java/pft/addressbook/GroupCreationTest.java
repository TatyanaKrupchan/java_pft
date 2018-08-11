package pft.addressbook;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class GroupCreationTest {
    FirefoxDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        final String loginName = "admin";
        final String loginPassword = "secret";

        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        login(loginName, loginPassword);
    }

    private void login(String login, String password) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(login);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();

    }

    @Test
    public void testForGroup() {
        // wd.findElement(By.xpath("//div[@id='content']//h1[.='GROUPS']")).click();
        gotoGroupsTab();
        initCreateNewGroup();
        fillNewGroupData(new GroupData("Test_groupname1", "Test_groupheader1", "Test_comment1"));
        submitNewGroupData();
        returnBackToGroupsTab();
    }

    private void returnBackToGroupsTab() {
        wd.findElement(By.linkText("group page")).click();
    }

    private void gotoGroupsTab() {
        wd.findElement(By.linkText("GROUPS")).click();
    }

    private void submitNewGroupData() {
        wd.findElement(By.name("submit")).click();
    }

    private void fillNewGroupData(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getGroupName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getGroupHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getGroupComment());
    }

    private void initCreateNewGroup() {
        wd.findElement(By.name("new")).click();
    }


    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
