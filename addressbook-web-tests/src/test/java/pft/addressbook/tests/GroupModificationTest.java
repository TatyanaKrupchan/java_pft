package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification() {

        GroupData editData = new GroupData("Test_edit_groupname1", "Test_edit_groupheader1",
                "Test_edit_comment1");
        app.getNavigationHelper().gotoGroupsTab();
        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup(new GroupData("Test_groupname1", null, null));
            app.getNavigationHelper().returnBackToGroupsTab();
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillNewGroupData(editData);
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().returnBackToGroupsTab();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
    }
}
