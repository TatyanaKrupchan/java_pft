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
        ContactData contactDetails = new ContactData()
                .withFirstName("Test_FirstName " + generatedString).withMiddleName("Test_MiddleName").withLastName("Test_LastName " + generatedString)
                .withNickName("Test_Nickname").withTitle("Test_Title").withCompany("Test_Company").withAddress("Test_Address")
                .withHomePhone("Test_PhoneHome").withMobilePhone("Test_PhoneMobile").withWorkPhone("Test_PhoneWork").withFax("Test_Fax")
                .withEmail1("Test_Email").withEmail2("Test_Email2");
        ContactData contactDetailsShort = new ContactData().withFirstName(contactDetails.getFirstName()).withLastName(contactDetails.getLastName())
                .withAddress(contactDetails.getAddress()).withHomePhone(contactDetails.getHomePhone())
                .withMobilePhone(contactDetails.getMobilePhone()).withWorkPhone(contactDetails.getWorkPhone())
                .withEmail1(contactDetails.getEmail1()).withEmail2(contactDetails.getEmail2());
        System.out.println("New name generated: " + generatedString);
        List<ContactData> before = app.contactHelper().getContactsList();
        app.contactHelper().createNewContact(contactDetails);
        app.goTo().returnToHomePage();
        List<ContactData> after = app.contactHelper().getContactsList();
        before.add(contactDetailsShort);
        Comparator<? super ContactData> byLastName = (g1, g2) -> g1.getLastName().compareTo(g2.getLastName());
        before.sort(byLastName);
        after.sort(byLastName);

        System.out.println("Before: " + before);
        System.out.println("After: " + after);

        Assert.assertEquals(after, before);
    }
}
