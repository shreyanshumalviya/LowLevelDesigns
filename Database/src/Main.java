import Database.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DatabaseManager.getInstance().addDatabase("database1");
        var database1 = DatabaseManager.getInstance().getDatabaseByName("database1");

        Map<String, Constraint> schemaConstrainsMap1 = new HashMap<>();
        schemaConstrainsMap1.put("id", new Constraint(ColumnType.INT_COLUMN, 1000));
        schemaConstrainsMap1.put("name", new Constraint(ColumnType.STRING_COLUMN, 45));

        var schema = new Schema(schemaConstrainsMap1);
        database1.createNewTable(schema, "table1");

        var table1 = database1.getTableByName("table1");

        var row1Map = new HashMap<String, Column>();
        row1Map.put("id",new IntColumn("id",1));
        row1Map.put("name",new StringColumn("name","testName1"));
        var row1 = new Row(row1Map);
        try {
            table1.addRow(row1);
            System.out.println("row 1 added");
        } catch (SchemaNotFollowedException e) {
            System.out.println("cannot add row 1");
        }

        var row2Map = new HashMap<String, Column>();
        row2Map.put("id",new StringColumn("id","1"));
        row2Map.put("name",new StringColumn("name","testName1"));
        var row2 = new Row(row2Map);
        try {
            table1.addRow(row2);
            System.out.println("row 2 added");
        } catch (SchemaNotFollowedException e) {
            System.out.println("cannot add row 2");
        }


    }
}