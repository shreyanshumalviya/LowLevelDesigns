package GoogleDrive;

import GoogleDrive.exceptions.AccessDeniedException;

public interface FileSystemElement {
    String getName();

    void setName(String name);

    long getSize();

    void addSharedUser(User requestingUser, User user, AccessLevel level) throws AccessDeniedException;
}
