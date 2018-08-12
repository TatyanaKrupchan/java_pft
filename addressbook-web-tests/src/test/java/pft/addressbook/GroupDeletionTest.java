package pft.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTest extends BaseTest {

    @Test
    public void testGroupDeletion() {
        gotoGroupsTab();
        selectGroup();
        deleteGroup();
        returnBackToGroupsTab();
    }
}
