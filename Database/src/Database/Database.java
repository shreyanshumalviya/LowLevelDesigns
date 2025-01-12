package Database;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private String name;
    private Map<String, Table> tables;

    public Database(String name) {
        this.name = name;
        tables = new HashMap<>();
    }

    public void createNewTable(Schema schema, String name){
        tables.put(name, new Table(name, schema));
    }

    public Table getTableByName(String name){
        return tables.get(name);
    }

}
