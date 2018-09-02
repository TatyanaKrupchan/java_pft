package pft.addressbook.tests;

import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;
import pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
        Contacts before = app.contactHelper().getContactsSet();
        app.contactHelper().createNewContact(contactDetails);
        app.goTo().returnToHomePage();
        Contacts after = app.contactHelper().getContactsSet();

        assertThat(after,
                equalTo(before.withAdded(contactDetailsShort.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
