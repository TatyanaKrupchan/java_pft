package pft.addressbook.tests;

import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;
import pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

    @Test
    public void testForGroup() {
        app.goTo().groupsTab();
        Groups before = app.groupHelper().groupSet();
        GroupData group = new GroupData().withGroupName("Test_groupname2").withGroupHeader("Test_groupheader2").withGroupComment("Test_comment2");
        app.groupHelper().createGroup(group);
        app.goTo().returnBackToGroupsTab();
        Groups after = app.groupHelper().groupSet();

        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())), equalTo(after));
    }
}
