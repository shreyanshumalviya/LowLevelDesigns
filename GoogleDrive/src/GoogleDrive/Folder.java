package GoogleDrive;

import GoogleDrive.exceptions.AccessDeniedException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Folder implements FileSystemElement {
    private final User owner;
    private final Map<String, FileSystemElement> elements;
    private String name;

    private Map<User, AccessLevel> accessLevelMap;

    public Folder(String name, User owner) {
        this.elements = new HashMap<>();
        this.name = name;
        this.accessLevelMap = new ConcurrentHashMap<>();
        this.owner = owner;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long getSize() {
        return elements.values().stream().mapToLong(FileSystemElement::getSize).sum();
        // throw too much to calculate error
    }

    public FileSystemElement readContent(User user, String fileName) throws AccessDeniedException {
        if (!Objects.equals(accessLevelMap.get(user), AccessLevel.READ))
            throw new AccessDeniedException();
        return elements.get(fileName);
    }

    public List<String> getAllNames(User user) throws AccessDeniedException {
        if (!Objects.equals(accessLevelMap.get(user), AccessLevel.READ))
            throw new AccessDeniedException();
        return elements.values().stream().map(FileSystemElement::getName).toList();
    }

    @Override
    public void addSharedUser(User requestingUser, User user, AccessLevel level) throws AccessDeniedException {
        if (requestingUser != owner)
            throw new AccessDeniedException();
        accessLevelMap.put(user, level);
    }

    public void addFileSystemElement(FileSystemElement fileSystemElement) {
        this.elements.put(fileSystemElement.getName(), fileSystemElement);
    }

    public void removeFileSystemElement(FileSystemElement fileSystemElement) {
        this.elements.remove(fileSystemElement);
    }
}
