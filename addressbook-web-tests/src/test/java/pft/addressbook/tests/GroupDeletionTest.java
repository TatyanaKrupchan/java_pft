package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class GroupDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.groupHelper().addGroupIfNotExist(app);
    }

    @Test
    public void testGroupDeletion() {
        Set<GroupData> before = app.groupHelper().groupSet();
        GroupData deleteGroup = before.iterator().next();
        app.groupHelper().deleteGroup(deleteGroup, app);
        Set<GroupData> after = app.groupHelper().groupSet();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deleteGroup);
        Assert.assertEquals(after, before);
    }
}
