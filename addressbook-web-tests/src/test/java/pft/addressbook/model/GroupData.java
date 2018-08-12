package pft.addressbook.model;

public class GroupData {
    private final String groupName;
    private final String groupHeader;
    private final String groupComment;

    public GroupData(String groupName, String groupHeader, String groupComment) {
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupComment = groupComment;
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
}
