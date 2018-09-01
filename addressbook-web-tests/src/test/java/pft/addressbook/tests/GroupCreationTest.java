package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {

    @Test
    public void testForGroup() {
        app.getNavigationHelper().gotoGroupsTab();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("Test_groupname2", "Test_groupheader2", "Test_comment2");
        app.getGroupHelper().createGroup(group);
        app.getNavigationHelper().returnBackToGroupsTab();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);

        // group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
