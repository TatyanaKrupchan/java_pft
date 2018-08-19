package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void submitNewContactData() {
        click(By.name("theform"));
        // wd.findElement(By.name("theform")).click();
    }

    public void fillContactData(ContactData contactData) {
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

    public void initiateCreateNewContact() {
        click(By.linkText("ADD_NEW"));
        // wd.findElement(By.linkText()).click();
    }
}