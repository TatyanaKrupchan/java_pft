package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

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
        List<ContactData> before = app.getContactHelper().getContactsList();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().acceptContactDeletion(1);
        app.getNavigationHelper().waitForRedirectionToMainPage();

        List<ContactData> after = app.getContactHelper().getContactsList();
        before.remove(0);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        /*Comparator<? super ContactData> byLastName = (g1, g2) ->  g1.getLastName().compareTo(g2.getLastName());
        before.sort(byLastName);
        after.sort(byLastName);*/

        System.out.println("Before: " + before);
        System.out.println("After: " + after);
        Assert.assertEquals(after, before);
    }
}
