package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pft.addressbook.model.ContactData;
import pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitNewContactData() {
        click(By.name("theform"));
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

    public void deleteContact(int countToRemove, ApplicationManager app) {
        selectContact();
        click(By.xpath("//div[@id='content']//input[@value='DELETE']"));
        acceptContactDeletion(countToRemove);
        app.goTo().waitForRedirectionToMainPage();
    }

    public void deleteContact(ContactData contact, int countToRemove, ApplicationManager app) {
        selectContactById(contact.getId());
        click(By.xpath("//div[@id='content']//input[@value='DELETE']"));
        acceptContactDeletion(countToRemove);
        app.goTo().waitForRedirectionToMainPage();
    }

    private void selectContactById(int id) {
        WebElement element = wd.findElement(By.cssSelector("input[value='" + id + "']"));
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void acceptContactDeletion(int recordsCount) {
        String alertText = "Delete " + recordsCount + " addresses?";
        acceptAlertWithVerification(alertText);
    }

    public void initModification(ContactData contact) {
        wd.findElement(By.xpath("//input[@value='" + contact.getId()+ "']/ancestor::tr//a/img[@title='EDIT']")).click();
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

    public void addContactIfNotExist(ApplicationManager app) {
        if (app.contactHelper().getContactsList().size() == 0) {
            String generatedString = app.randomString(10);
            ContactData contactDetails = new ContactData().withFirstName("Test_FirstName " + generatedString)
                    .withEmail1("Test_Email").withEmail2("Test_Email2");
            app.contactHelper().createNewContact(contactDetails);
            app.goTo().returnToHomePage();
        }
    }

    public void modifyContact(ContactData contact, ContactData contactDetailsEdited, ApplicationManager app) {
        app.contactHelper().initModification(contact);
        app.contactHelper().fillContactData(contactDetailsEdited);
        app.contactHelper().submitContactModificationData();
        app.goTo().waitForRedirectionToMainPage();
    }

    public List<ContactData> getContactsList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String lastName = element.findElement(By.xpath(".//td[2]")).getText();
            String firstName = element.findElement(By.xpath(".//td[3]")).getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            ContactData contact = new ContactData().withId(Integer.parseInt(id)).withFirstName(firstName).withLastName(lastName);
            contacts.add(contact);
        }
        return contacts;
    }

    public Contacts getContactsSet() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String lastName = element.findElement(By.xpath(".//td[2]")).getText();
            String firstName = element.findElement(By.xpath(".//td[3]")).getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            ContactData contact = new ContactData().withId(Integer.parseInt(id)).withFirstName(firstName).withLastName(lastName);
            contacts.add(contact);
        }
        return contacts;

    }
}
