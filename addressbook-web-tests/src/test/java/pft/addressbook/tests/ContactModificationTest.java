package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.contactHelper().addGroupIfNotExist(app);
    }

    @Test
    public void testContactModification() {
        String generatedString = app.randomString(8);
        ContactData contactDetailsEdited = new ContactData().withFirstName("Test_FirstName_edit " + generatedString)
                .withMiddleName("Test_MiddleName_edit ").withLastName("Test_LastName_edit " + generatedString)
                .withNickName("Test_Nickname_edit").withTitle("Test_Title_edit").withCompany("Test_Company_edit")
                .withAddress("Test_Address_edit").withHomePhone("Test_PhoneHome_edit").withMobilePhone("Test_PhoneMobile_edit")
                .withWorkPhone("Test_PhoneWork_edit").withFax("Test_Fax_edit").withEmail1("Test_Email_edit").withEmail2("Test_Email2_edit");

        // in the test we edit the first contact record in the table
        Set<ContactData> before = app.contactHelper().getContactsSet();
        ContactData modifyContact = before.iterator().next();

        app.contactHelper().modifyContact(contactDetailsEdited, app);
        Set<ContactData> after = app.contactHelper().getContactsSet();
        before.remove(modifyContact);
        before.add(contactDetailsEdited);

        System.out.println("Before: " + before);
        System.out.println("After: " + after);

        Assert.assertEquals(after, before);
    }
}
