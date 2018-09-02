package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationTest extends TestBase {

    @Test
    public void testForGroup() {
        app.goTo().groupsTab();
        Set<GroupData> before = app.groupHelper().groupSet();
        GroupData group = new GroupData().withGroupName("Test_groupname2").withGroupHeader("Test_groupheader2").withGroupComment("Test_comment2");
        app.groupHelper().createGroup(group);
        app.goTo().returnBackToGroupsTab();
        Set<GroupData> after = app.groupHelper().groupSet();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after);
    }
}
