package pft.addressbook.model;

import java.util.Objects;

public class GroupData {
    private int id = Integer.MAX_VALUE;
    private String groupName;
    private String groupHeader;
    private String groupComment;

    /*public GroupData(int id, String groupName, String groupHeader, String groupComment) {
        this.id = id;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupComment = groupComment;
    }

    public GroupData(String groupName, String groupHeader, String groupComment) {
        this.id = Integer.MAX_VALUE;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupComment = groupComment;
    }*/

    public int getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public String getGroupComment() {
        return groupComment;
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    public GroupData withGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupData withGroupHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }

    public GroupData withGroupComment(String groupComment) {
        this.groupComment = groupComment;
        return this;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(groupName, groupData.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }
}
