package Database;

import java.util.HashMap;
import java.util.Map;

public class DatabaseManager {
    Map<String, Database> databases;

    private static DatabaseManager databaseManager;

    public static DatabaseManager getInstance() {
        if (databaseManager == null) databaseManager = new DatabaseManager();
        return databaseManager;
    }

    public DatabaseManager() {
        databases = new HashMap<>();
    }

    public void addDatabase(String name){
        databases.put(name, new Database(name));
    }

    public Database getDatabaseByName(String name){
        return databases.get(name);
    }
}
