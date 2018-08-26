package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() {
        if (!app.getContactHelper().isContactPresent()) {
            String generatedString = app.randomString(10);
            ContactData contactDetails = new ContactData("Test_FirstName " + generatedString, null, null,
                    null, null, null, null,
                    null, null, null, null,
                    "Test_Email", "Test_Email2");

            app.getContactHelper().createNewContact(contactDetails);
            app.getNavigationHelper().returnToHomePage();
        }
        int before = app.getContactHelper().getContactsCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().acceptContactDeletion(1);
        app.getNavigationHelper().waitForRedirectionToMainPage();
        int after = app.getContactHelper().getContactsCount();
        Assert.assertEquals(after, before - 1);
    }
}
