package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

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

        /*if (!app.contactHelper().isContactPresent()) {
            generatedString = app.randomString(10);
            ContactData contactDetails = new ContactData("Test_FirstName " + generatedString, null, null,
                    null, null, null, null,
                    null, null, null, null,
                    "Test_Email", "Test_Email2");
            app.contactHelper().createNewContact(contactDetails);
            app.goTo().returnToHomePage();
        }*/

        // int before = app.contactHelper().getContactsCount();
        // in the test we edit the first contact record in the table
        List<ContactData> before = app.contactHelper().getContactsList();
        app.contactHelper().modifyContact(contactDetailsEdited, app);
        List<ContactData> after = app.contactHelper().getContactsList();
        before.remove(0);
        before.add(contactDetailsEdited);
        // Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        Comparator<? super ContactData> byLastName = (g1, g2) -> g1.getLastName().compareTo(g2.getLastName());
        before.sort(byLastName);
        after.sort(byLastName);

        System.out.println("Before: " + before);
        System.out.println("After: " + after);

        Assert.assertEquals(after, before);
        /*int after = app.contactHelper().getContactsCount();
        Assert.assertEquals(after, before);*/
    }
}
