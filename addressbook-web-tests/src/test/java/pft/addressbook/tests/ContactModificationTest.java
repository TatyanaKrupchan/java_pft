package pft.addressbook.tests;

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
        app.getContactHelper().initModification();
        app.getContactHelper().fillContactData(contactDetailsEdited);
        app.getContactHelper().submitContactModificationData();
        app.getContactHelper().waitForRedirectionToMainPage();
    }
}
