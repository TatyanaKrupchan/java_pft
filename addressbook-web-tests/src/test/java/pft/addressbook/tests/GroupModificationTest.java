package pft.addressbook.tests;

import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification() {

        GroupData editData = new GroupData("Test_edit_groupname1", "Test_edit_groupheader1",
                "Test_edit_comment1");
        app.getNavigationHelper().gotoGroupsTab();
        if (! app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup(new GroupData("Test_groupname1", null, null));
            app.getNavigationHelper().returnBackToGroupsTab();
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillNewGroupData(editData);
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().returnBackToGroupsTab();

    }
}
