package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.groupHelper().addGroupIfNotExist(app);
    }

    @Test
    public void testGroupDeletion() {
        List<GroupData> before = app.groupHelper().groupList();
        int groupIndex = before.size() - 1;
        app.groupHelper().deleteGroup(groupIndex, app);
        List<GroupData> after = app.groupHelper().groupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(groupIndex);
        Assert.assertEquals(after, before);
    }
}
