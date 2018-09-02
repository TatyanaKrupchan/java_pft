package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pft.addressbook.model.GroupData;
import pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void submitNewGroupData() {
        click(By.name("submit"));
    }

    public void fillNewGroupData(GroupData groupData) {
        fillAField("group_name", groupData.getGroupName());
        fillAField("group_header", groupData.getGroupHeader());
        fillAField("group_footer", groupData.getGroupComment());
    }

    public void initCreateNewGroup() {
        click(By.name("new"));
    }

    public void deleteGroup(int groupIndex, ApplicationManager app) {
        selectGroup(groupIndex);
        click(By.name("delete"));
        app.goTo().returnBackToGroupsTab();
    }

    public void deleteGroup(GroupData group, ApplicationManager app){
        selectGroupById(group.getId());
        click(By.name("delete"));
        app.goTo().returnBackToGroupsTab();

    }

    public void addGroupIfNotExist(ApplicationManager app){
        app.goTo().groupsTab();
        if (groupList().size() == 0) {
            createGroup(new GroupData().withGroupName("Test_groupname1"));
            app.goTo().returnBackToGroupsTab();
        }
    }

    public void modifyGroupData(int groupIndex, GroupData editData, ApplicationManager app){
        selectGroup(groupIndex);
        initGroupModification();
        fillNewGroupData(editData);
        submitGroupModification();
        app.goTo().returnBackToGroupsTab();
    }

    public void modifyGroupData(GroupData editData, ApplicationManager app){
        selectGroupById(editData.getId());
        initGroupModification();
        fillNewGroupData(editData);
        submitGroupModification();
        app.goTo().returnBackToGroupsTab();
    }

    public void selectGroup() {
        if (!wd.findElement(By.name("selected[]")).isSelected()) {
            click(By.name("selected[]"));
        }
    }

    public void selectGroup(int index) {
        WebElement element = wd.findElements(By.name("selected[]")).get(index);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void selectGroupById(int id) {
        WebElement element = wd.findElement(By.cssSelector("input[value='"+ id +"']"));
        if (!element.isSelected()) {
            element.click();
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

    public List<GroupData> groupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            GroupData group = new GroupData().withId(Integer.parseInt(id)).withGroupName(name);
            groups.add(group);
        }
        return groups;
    }

    public Groups groupSet() {
        Groups groups = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            GroupData group = new GroupData().withId(Integer.parseInt(id)).withGroupName(name);
            groups.add(group);
        }
        return groups;
    }

}
