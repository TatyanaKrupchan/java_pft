package pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;
import pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.groupHelper().addGroupIfNotExist(app);
    }

    @Test
    public void testGroupModification() {
        Groups before = app.groupHelper().groupSet();
        GroupData modifiedGroup = before.iterator().next();
        GroupData editData = new GroupData().withId(modifiedGroup.getId()).withGroupName("Test_edit_groupname1")
                .withGroupHeader("Test_edit_groupheader1").withGroupComment("Test_edit_comment1");

        app.groupHelper().modifyGroupData(editData, app);
        Groups after = app.groupHelper().groupSet();
        assertThat(after.size(), equalTo(before.size()));

        assertThat(before.withoutGroup(modifiedGroup).withAdded(editData), equalTo(after));
    }
}
