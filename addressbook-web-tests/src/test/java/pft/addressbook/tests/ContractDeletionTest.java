package pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContractDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().acceptContactDeletion(1);
    }
}
