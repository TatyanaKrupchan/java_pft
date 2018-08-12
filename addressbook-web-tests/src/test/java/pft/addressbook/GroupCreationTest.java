package pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTest extends BaseTest{

    @Test
    public void testForGroup() {
        // wd.findElement(By.xpath("//div[@id='content']//h1[.='GROUPS']")).click();
        gotoGroupsTab();
        initCreateNewGroup();
        fillNewGroupData(new GroupData("Test_groupname1", "Test_groupheader1", "Test_comment1"));
        submitNewGroupData();
        returnBackToGroupsTab();
    }


}
