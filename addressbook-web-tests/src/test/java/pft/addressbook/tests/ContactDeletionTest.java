package pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;
import pft.addressbook.model.Contacts;
import pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.contactHelper().addGroupIfNotExist(app);
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.contactHelper().getContactsSet();
        ContactData deleteContact = before.iterator().next();

        int countToRemove = 1;
        app.contactHelper().deleteContact(deleteContact, countToRemove, app);

        Contacts after = app.contactHelper().getContactsSet();
        assertThat(after, equalTo(before.withoutContact(deleteContact)));
    }
}
