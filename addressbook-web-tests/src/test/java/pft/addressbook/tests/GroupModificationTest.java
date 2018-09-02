package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.groupHelper().addGroupIfNotExist(app);
    }

    @Test
    public void testGroupModification() {
        List<GroupData> before = app.groupHelper().groupList();
        int groupIndex = before.size() - 1;
        GroupData editData = new GroupData().withId(before.get(groupIndex).getId()).withGroupName("Test_edit_groupname1")
                .withGroupHeader("Test_edit_groupheader1").withGroupComment("Test_edit_comment1");

        app.groupHelper().modifyGroupData(groupIndex, editData, app);
        List<GroupData> after = app.groupHelper().groupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(groupIndex);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        before.add(editData);
        Assert.assertEquals(before, after);
    }
}
