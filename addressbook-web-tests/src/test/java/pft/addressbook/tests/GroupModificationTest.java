package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.groupHelper().addGroupIfNotExist(app);
    }

    @Test
    public void testGroupModification() {
        Set<GroupData> before = app.groupHelper().groupSet();
        GroupData modifiedGroup = before.iterator().next();
        GroupData editData = new GroupData().withId(modifiedGroup.getId()).withGroupName("Test_edit_groupname1")
                .withGroupHeader("Test_edit_groupheader1").withGroupComment("Test_edit_comment1");

        app.groupHelper().modifyGroupData(editData, app);
        Set<GroupData> after = app.groupHelper().groupSet();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedGroup);

        before.add(editData);
        Assert.assertEquals(before, after);
    }
}
