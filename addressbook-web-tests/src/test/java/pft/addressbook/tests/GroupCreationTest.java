package pft.addressbook.tests;

import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

    @Test
    public void testForGroup() {
        // wd.findElement(By.xpath("//div[@id='content']//h1[.='GROUPS']")).click();
        app.gotoGroupsTab();
        app.initCreateNewGroup();
        app.fillNewGroupData(new GroupData("Test_groupname1", "Test_groupheader1", "Test_comment1"));
        app.submitNewGroupData();
        app.returnBackToGroupsTab();
    }


}
