package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
        String generatedString = app.randomString(8);
        ContactData contactDetailsEdited = new ContactData("Test_FirstName_edit " + generatedString, "Test_MiddleName_edit ", "Test_LastName_edit " + generatedString,
                "Test_Nickname_edit", "Test_Title_edit", "Test_Company_edit", "Test_Address_edit",
                "Test_PhoneHome_edit", "Test_PhoneMobile_edit", "Test_PhoneWork_edit", "Test_Fax_edit",
                "Test_Email_edit", "Test_Email2_edit");
        /*ContactData contactDetailsEditedShort = new ContactData(contactDetailsEdited.getFirstName(), null, contactDetailsEdited.getLastName(),
                null, null, null, contactDetailsEdited.getAddress(),
                contactDetailsEdited.getHomePhone(), contactDetailsEdited.getMobilePhone(), contactDetailsEdited.getWorkPhone(), null,
                contactDetailsEdited.getEmail1(), contactDetailsEdited.getEmail2());*/

        if (!app.getContactHelper().isContactPresent()) {
            generatedString = app.randomString(10);
            ContactData contactDetails = new ContactData("Test_FirstName " + generatedString, null, null,
                    null, null, null, null,
                    null, null, null, null,
                    "Test_Email", "Test_Email2");
            app.getContactHelper().createNewContact(contactDetails);
            app.getNavigationHelper().returnToHomePage();
        }

        // int before = app.getContactHelper().getContactsCount();

        List<ContactData> before = app.getContactHelper().getContactsList();
        app.getContactHelper().initModification();
        app.getContactHelper().fillContactData(contactDetailsEdited);
        app.getContactHelper().submitContactModificationData();
        app.getNavigationHelper().waitForRedirectionToMainPage();

        List<ContactData> after = app.getContactHelper().getContactsList();
        before.remove(0);
        before.add(contactDetailsEdited);
        // Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        Comparator<? super ContactData> byLastName = (g1, g2) ->  g1.getLastName().compareTo(g2.getLastName());
        before.sort(byLastName);
        after.sort(byLastName);

        System.out.println("Before: " + before);
        System.out.println("After: " + after);

        Assert.assertEquals(after, before);


        /*int after = app.getContactHelper().getContactsCount();
        Assert.assertEquals(after, before);*/

    }
}
