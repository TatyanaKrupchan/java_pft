package pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.gotoGroupsTab();
        app.selectGroup();
        app.deleteGroup();
        app.returnBackToGroupsTab();
    }
}
