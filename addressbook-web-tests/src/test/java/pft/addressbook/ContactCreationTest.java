package pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends BaseTest{

    @Test
    public void testContactCreation() {
        String generatedString = randomString(10);
        ContactData contactDetails = new ContactData("Test_FirstName " + generatedString, "Test_MiddleName", "Test_LastName " + generatedString,
                "Test_Nickname", "Test_Title", "Test_Company", "Test_Address",
                "Test_PhoneHome", "Test_PhoneMobile", "Test_PhoneWork", "Test_Fax",
                "Test_Email", "Test_Email2");
        System.out.println("New name generated: " + generatedString);
        initiateCreateNewContact();
        fillContactData(contactDetails);
        submitNewContactData();
        returnToHomePage();
    }


}
