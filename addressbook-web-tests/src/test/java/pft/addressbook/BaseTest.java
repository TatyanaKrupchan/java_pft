package pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    FirefoxDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        final String login = "admin";
        final String password = "secret";
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        login(login, password);
    }

    private void login(String login, String password) {
        fillAField("user", login);
        fillAField("pass", password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    private void fillAField(String fieldName, String fieldValue) {
        wd.findElement(By.name(fieldName)).click();
        wd.findElement(By.name(fieldName)).clear();
        wd.findElement(By.name(fieldName)).sendKeys(fieldValue);
    }

    protected String randomString(int len) {
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    protected void returnToHomePage() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    protected void submitNewContactData() {
        wd.findElement(By.name("theform")).click();
    }

    protected void fillContactData(ContactData contactData) {
        // wd.findElement(By.name("theform")).click();
        fillAField("firstname", contactData.getFirstName());
        fillAField("middlename", contactData.getMiddleName());
        fillAField("lastname", contactData.getLastName());
        fillAField("nickname", contactData.getNickName());
        fillAField("title", contactData.getTitle());
        fillAField("company", contactData.getCompany());
        fillAField("address", contactData.getAddress());
        fillAField("home", contactData.getHomePhone());
        fillAField("mobile", contactData.getMobilePhone());
        fillAField("work", contactData.getWorkPhone());
        fillAField("fax", contactData.getFax());
        fillAField("email", contactData.getEmail1());
        fillAField("email2", contactData.getEmail2());
    }

    protected void initiateCreateNewContact() {
        wd.findElement(By.linkText("ADD_NEW")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    protected void returnBackToGroupsTab() {
        wd.findElement(By.linkText("group page")).click();
    }

    protected void gotoGroupsTab() {
        wd.findElement(By.linkText("GROUPS")).click();
    }

    protected void submitNewGroupData() {
        wd.findElement(By.name("submit")).click();
    }

    protected void fillNewGroupData(GroupData groupData) {
        fillAField("group_name", groupData.getGroupName());
        fillAField("group_header", groupData.getGroupHeader());
        fillAField("group_footer", groupData.getGroupComment());
    }

    protected void initCreateNewGroup() {
        wd.findElement(By.name("new")).click();
    }

    protected void deleteGroup() {
        wd.findElement(By.name("delete")).click();
    }

    protected void selectGroup() {
        if (!wd.findElement(By.name("selected[]")).isSelected()) {
            wd.findElement(By.name("selected[]")).click();
        }
    }
}
