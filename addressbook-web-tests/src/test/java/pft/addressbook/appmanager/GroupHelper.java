package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void submitNewGroupData() {
        click(By.name("submit"));
        // wd.findElement(By.name("submit")).click();
    }

    public void fillNewGroupData(GroupData groupData) {
        fillAField("group_name", groupData.getGroupName());
        fillAField("group_header", groupData.getGroupHeader());
        fillAField("group_footer", groupData.getGroupComment());
    }

    public void initCreateNewGroup() {
        click(By.name("new"));
        // wd.findElement(By.name("new")).click();
    }

    public void deleteGroup() {
        click(By.name("delete"));
        // wd.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
        if (!wd.findElement(By.name("selected[]")).isSelected()) {
            click(By.name("selected[]"));
            // wd.findElement(By.name("selected[]")).click();
        }
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void createGroup(GroupData group) {
        initCreateNewGroup();
        fillNewGroupData(group);
        submitNewGroupData();
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
