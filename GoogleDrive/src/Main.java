import GoogleDrive.*;
import GoogleDrive.exceptions.AccessDeniedException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        var u1 = new User("userName1");
        var folder1 = new Folder("folder1", u1);
        var folder2 = new Folder("folder2", u1);
        folder1.addFileSystemElement(folder2);
        var file1 = new TextFile(u1, "this is file 1", "file1");
        var file2 = new TextFile(u1, "this is file 2", "file2");
        folder1.addFileSystemElement(file1);
        folder2.addFileSystemElement(file2);

        var u2 = new User("userName2");
        UserManager.getInstance().addNewUser(u1);
        UserManager.getInstance().addNewUser(u2);

        try {
            folder2.getAllNames(u2);
        } catch (AccessDeniedException e) {
            System.out.println("nope not allowed");
        }

        try {
            folder2.addSharedUser(u2, u2, AccessLevel.READ);
        } catch (AccessDeniedException e) {
            System.out.println("nope not allowed");
        }

        try {
            folder2.addSharedUser(u1, u2, AccessLevel.READ);
        } catch (AccessDeniedException e) {
            System.out.println("nope not allowed");
        }

        try {
            FileSystemElement fileSystemElement = folder2.readContent(u2, folder2.getAllNames(u2).get(0));
            System.out.println(((File) fileSystemElement).getFileContent());
        } catch (AccessDeniedException e) {
            throw new RuntimeException(e);
        }

    }
}