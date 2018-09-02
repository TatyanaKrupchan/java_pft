package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        String generatedString = app.randomString(10);
        ContactData contactDetails = new ContactData("Test_FirstName " + generatedString, "Test_MiddleName", "Test_LastName " + generatedString,
                "Test_Nickname", "Test_Title", "Test_Company", "Test_Address",
                "Test_PhoneHome", "Test_PhoneMobile", "Test_PhoneWork", "Test_Fax",
                "Test_Email", "Test_Email2");
        ContactData contactDetailsShort = new ContactData(contactDetails.getFirstName(), null, contactDetails.getLastName(),
                null, null, null, contactDetails.getAddress(),
                contactDetails.getHomePhone(), contactDetails.getMobilePhone(), contactDetails.getWorkPhone(), null,
                contactDetails.getEmail1(), contactDetails.getEmail2());
        System.out.println("New name generated: " + generatedString);
        List<ContactData> before = app.getContactHelper().getContactsList();
        app.getContactHelper().createNewContact(contactDetails);
        app.goTo().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactsList();
        before.add(contactDetailsShort);
        Comparator<? super ContactData> byLastName = (g1, g2) ->  g1.getLastName().compareTo(g2.getLastName());
        before.sort(byLastName);
        after.sort(byLastName);

        System.out.println("Before: " + before);
        System.out.println("After: " + after);

        Assert.assertEquals(after, before);
    }
}
