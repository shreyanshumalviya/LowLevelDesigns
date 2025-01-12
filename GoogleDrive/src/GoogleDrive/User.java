package GoogleDrive;

import java.util.HashMap;
import java.util.Map;

public class User {
    private Folder drive;
    private String username;
    private Map<String, FileSystemElement> fileSystemElements;

    public User(String username) {
        this.username = username;
        this.fileSystemElements = new HashMap<>();
    }

    void anotherFileShared(FileSystemElement fileSystemElement) {
        fileSystemElements.put(fileSystemElement.getName(), fileSystemElement);
    }

    public String getUsername() {
        return username;
    }

    public void setDrive(Folder drive) {
        this.drive = drive;
    }
}
