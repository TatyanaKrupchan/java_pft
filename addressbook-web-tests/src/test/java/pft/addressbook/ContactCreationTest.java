package pft.addressbook;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;


public class ContactCreationTest {
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

    private String randomString(int len) {
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    @Test
    public void testContactCreation() {
        String generatedString = randomString(10);
        ContactData contactDetails = new ContactData("Test_FirstName " + generatedString, "Test_MiddleName", "Test_LastName " + generatedString,
                "Test_Nickname", "Test_Title", "Test_Company", "Test_Address",
                "Test_PhoneHome", "Test_PhoneMobile", "Test_PhoneWork", "Test_Fax",
                "Test_Email", "Test_Email2");
        System.out.println("New name generated: " + generatedString);
        initiateCreateNewContact();
        fillContactData(contactDetails);
        submitNewContactData();
        returnToHomePage();
    }

    private void returnToHomePage() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }


    private void submitNewContactData() {
        wd.findElement(By.name("theform")).click();
    }

    private void fillContactData(ContactData contactData) {
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

    private void initiateCreateNewContact() {
        wd.findElement(By.linkText("ADD_NEW")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

}
