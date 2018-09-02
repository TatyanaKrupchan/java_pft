package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;
import pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.contactHelper().addGroupIfNotExist(app);
    }

    @Test
    public void testContactDeletion() {
        Set<ContactData> before = app.contactHelper().getContactsSet();
        ContactData deleteContact = before.iterator().next();

        int countToRemove = 1;
        app.contactHelper().deleteContact(deleteContact, countToRemove, app);

        Set<ContactData> after = app.contactHelper().getContactsSet();
        before.remove(deleteContact);

        System.out.println("Before: " + before);
        System.out.println("After: " + after);
        Assert.assertEquals(after, before);
    }
}
