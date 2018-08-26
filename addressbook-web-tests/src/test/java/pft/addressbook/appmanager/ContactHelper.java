package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pft.addressbook.model.ContactData;


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

    public void acceptContactDeletion(int recordsCount){
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
}
