package GoogleDrive;

import GoogleDrive.exceptions.AccessDeniedException;

public interface File extends FileSystemElement{

    void setContent(String content) throws AccessDeniedException;

    void updateContent(User user, String content) throws AccessDeniedException;

    String getFileContent();

}
