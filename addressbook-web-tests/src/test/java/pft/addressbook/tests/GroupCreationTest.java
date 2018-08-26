package pft.addressbook.tests;

import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

    @Test
    public void testForGroup() {
        // wd.findElement(By.xpath("//div[@id='content']//h1[.='GROUPS']")).click();
        app.getNavigationHelper().gotoGroupsTab();
        app.getGroupHelper().createGroup(new GroupData("Test_groupname1", "Test_groupheader1", "Test_comment1"));
        app.getNavigationHelper().returnBackToGroupsTab();
    }


}
