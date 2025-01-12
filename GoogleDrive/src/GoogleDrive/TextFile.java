package GoogleDrive;

import GoogleDrive.exceptions.AccessDeniedException;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class TextFile implements File{

    private final User owner;
    private String content;
    private Map<User, AccessLevel> accessLevelMap;
    private String name;

    public TextFile(User owner, String content, String name) {
        this.owner = owner;
        this.content = content;
        this.name = name;
        accessLevelMap = new ConcurrentHashMap<>();
    }

    @Override
    public void setContent(String content) throws AccessDeniedException {
        this.content = content;
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
        return this.content.length();
    }

    @Override
    public void updateContent(User user, String content) throws AccessDeniedException {
        if(!Objects.equals(accessLevelMap.get(user), AccessLevel.UPDATE)) {
            throw new AccessDeniedException();
        }
        this.content = content;
    }

    @Override
    public String getFileContent() {
        return this.content;
    }

    @Override
    public void addSharedUser(User requestingUser, User user, AccessLevel level) throws AccessDeniedException {
        if(requestingUser!= owner){
            throw new AccessDeniedException();
        }
        accessLevelMap.put(user, level);
        System.out.println("updated access");
    }
}
