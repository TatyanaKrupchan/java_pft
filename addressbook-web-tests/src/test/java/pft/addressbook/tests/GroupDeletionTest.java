package pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;
import pft.addressbook.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.groupHelper().addGroupIfNotExist(app);
    }

    @Test
    public void testGroupDeletion() {
        Groups before = app.groupHelper().groupSet();
        GroupData deleteGroup = before.iterator().next();
        app.groupHelper().deleteGroup(deleteGroup, app);
        Groups after = app.groupHelper().groupSet();
        assertThat(after.size(), equalTo(before.size() - 1));

        assertThat(after, equalTo(before.withoutGroup(deleteGroup)));
    }
}
