[URL to editable UML](https://editor.plantuml.com/uml/ZLJBRi8m4Bn7oZ-iE8KAVg0W16r1FG0zfFq0Arw89ST6jiEZb7-lNo413cqEITYT7S-C7QRQ46NgYgT9mOdMyALHmJbDm5wvKKnieRObGIeCnONar4AeOljOMJ9jnWl6CJzfWzK4T4aKqhOIO7l9A11Ayxjkra-JIvfq1Qo885kd0yBegnH5hHGAyqvqkIAxSQDfuF6J0DkYSRzUJkw-jjsi3wPKyX1Orz8iP2te_5ZWpZ0fRjQTrQRCKUrPWQx8X46r8GL2gtJEiR8QOZeFTNY6SuMcbFJYfEJi6vqtX_Mfsjh7GQ3A-gDGvTAcUqMEEZ4f9DIQDfOryxFExzNCh2XGwpSK35iptV5wHud11u91iwD5wFoVyBfjZgjB62QNk4SEtDsT3PzgcwmBocwaVtGYwdhiFxPlFTm9xv3xusZ7mx6q11k6tCxVdSguHnF0yA9RYayy6WTCa-ODnZ_38KH5FQQ1z5g1aJzAYP46lr74Kno-FnszacYeY3XPDf-X1pR2VVUwK2lXWQNH4mR_1dQ_ABUYN_fMpHG5zNy2lm00)
```
@startuml
class User {
    String username
    Folder drive
    List<FileSystem> sharedFileSystem
    void addSharedFileSystem()
}

class UserManager { 
    ConcurrentHashMap<username, User>
    getUserByUserName() throws UserNotFoundException
}

class AuthService

interface FileSystemElement{
    FileSystemElement : {method} getSize()
    User getOwner();
    long getSize();
    void readContent(User user) throws AccessDeniedException;
    void updateContent(User user, String content) throws AccessDeniedException;
    void addSharedUser(User user, AccessLevel level);
}



class File 
File : {method} readContent()
File : {method} updateContent(String content)

class Folder
Folder : {field} List<FileSystemElement> elements

class TextFile
TextFile <|-- File : "is a"
File : {field} content String


Folder *-- FileSystemElement : "has many"
User *-- Folder : "has a"
File  <|-- FileSystemElement : "is a"
Folder  <|-- FileSystemElement : "is a"
UserManager *-- User : "has many"
@enduml


```