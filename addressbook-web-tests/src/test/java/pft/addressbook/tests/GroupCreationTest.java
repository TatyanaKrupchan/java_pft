package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTest extends TestBase {

    @Test
    public void testForGroup() {
        app.goTo().groupsTab();
        List<GroupData> before = app.groupHelper().groupList();
        GroupData group = new GroupData().withGroupName("Test_groupname2").withGroupHeader("Test_groupheader2").withGroupComment("Test_comment2");
        app.groupHelper().createGroup(group);
        app.goTo().returnBackToGroupsTab();
        List<GroupData> after = app.groupHelper().groupList();
        Assert.assertEquals(after.size(), before.size() + 1);

        // group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
