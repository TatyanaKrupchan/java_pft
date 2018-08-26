package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {

    @Test
    public void testForGroup() {
        // wd.findElement(By.xpath("//div[@id='content']//h1[.='GROUPS']")).click();
        app.getNavigationHelper().gotoGroupsTab();
        // int before = app.getGroupHelper().getGroupsCount();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("Test_groupname1", "Test_groupheader1", "Test_comment1");
        app.getGroupHelper().createGroup(group);
        app.getNavigationHelper().returnBackToGroupsTab();
        // int after = app.getGroupHelper().getGroupsCount();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);

        int max = 0;
        for (GroupData g : after){
            if (g.getId() > 0){
                max = g.getId();
            }
        }
        group.setId(max);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));

    }


}
