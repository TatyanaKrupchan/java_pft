package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
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

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']//input[@value='DELETE']"));

    }

    public void acceptContactDeletion(int recordsCount) {
        String alertText = "Delete " + recordsCount + " addresses?";
        acceptAlertWithVerification(alertText);
    }

    public void initModification() {
        click(By.xpath("//a/img[@title='EDIT']"));
    }

    public void submitContactModificationData() {
        click(By.name("update"));
    }

    public void createNewContact(ContactData contactData) {
        initiateCreateNewContact();
        fillContactData(contactData);
        submitNewContactData();
    }

    public boolean isContactPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactsList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String lastName = element.findElement(By.xpath(".//td[2]")).getText();
            String firstName = element.findElement(By.xpath(".//td[3]")).getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            ContactData contact = new ContactData(Integer.parseInt(id), firstName, null, lastName, null, null, null,
                    null, null, null, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;

    }
}
