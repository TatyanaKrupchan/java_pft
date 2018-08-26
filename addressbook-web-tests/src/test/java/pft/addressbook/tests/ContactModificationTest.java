package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
        String generatedString = app.randomString(8);
        ContactData contactDetailsEdited = new ContactData("Test_FirstName_edit " + generatedString, "Test_MiddleName_edit ", "Test_LastName_edit " + generatedString,
                "Test_Nickname_edit", "Test_Title_edit", "Test_Company_edit", "Test_Address_edit",
                "Test_PhoneHome_edit", "Test_PhoneMobile_edit", "Test_PhoneWork_edit", "Test_Fax_edit",
                "Test_Email_edit", "Test_Email2_edit");
        if (!app.getContactHelper().isContactPresent()) {
            generatedString = app.randomString(10);
            ContactData contactDetails = new ContactData("Test_FirstName " + generatedString, null, null,
                    null, null, null, null,
                    null, null, null, null,
                    "Test_Email", "Test_Email2");
            app.getContactHelper().createNewContact(contactDetails);
            app.getNavigationHelper().returnToHomePage();
        }
        int before = app.getContactHelper().getContactsCount();
        app.getContactHelper().initModification();
        app.getContactHelper().fillContactData(contactDetailsEdited);
        app.getContactHelper().submitContactModificationData();
        app.getNavigationHelper().waitForRedirectionToMainPage();
        int after = app.getContactHelper().getContactsCount();
        Assert.assertEquals(after, before);

    }
}
