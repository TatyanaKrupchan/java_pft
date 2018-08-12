package pft.addressbook.tests;

import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        String generatedString = app.randomString(10);
        ContactData contactDetails = new ContactData("Test_FirstName " + generatedString, "Test_MiddleName", "Test_LastName " + generatedString,
                "Test_Nickname", "Test_Title", "Test_Company", "Test_Address",
                "Test_PhoneHome", "Test_PhoneMobile", "Test_PhoneWork", "Test_Fax",
                "Test_Email", "Test_Email2");
        System.out.println("New name generated: " + generatedString);
        app.initiateCreateNewContact();
        app.fillContactData(contactDetails);
        app.submitNewContactData();
        app.returnToHomePage();
    }


}
