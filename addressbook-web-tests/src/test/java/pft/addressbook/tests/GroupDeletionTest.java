package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupsTab();
        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup(new GroupData("Test_groupname1", null, null));
            app.getNavigationHelper().returnBackToGroupsTab();
        }
        int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroup(before - 1);
        app.getGroupHelper().deleteGroup();
        app.getNavigationHelper().returnBackToGroupsTab();
        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after, before - 1);

    }
}
