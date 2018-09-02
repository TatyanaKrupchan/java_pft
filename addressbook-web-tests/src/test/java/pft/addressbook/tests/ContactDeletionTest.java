package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.contactHelper().addGroupIfNotExist(app);
    }

    @Test
    public void testContactDeletion() {
        /*if (!app.contactHelper().isContactPresent()) {
            String generatedString = app.randomString(10);
            ContactData contactDetails = new ContactData().withFirstName("Test_FirstName " + generatedString)
                    .withEmail1("Test_Email").withEmail2("Test_Email2");
            app.contactHelper().createNewContact(contactDetails);
            app.goTo().returnToHomePage();
        }*/
        List<ContactData> before = app.contactHelper().getContactsList();
        int countToRemove = 1;
        // app.contactHelper().selectContact();
        app.contactHelper().deleteContact(countToRemove, app);
        // app.contactHelper().acceptContactDeletion(1);
        // app.goTo().waitForRedirectionToMainPage();

        List<ContactData> after = app.contactHelper().getContactsList();
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
