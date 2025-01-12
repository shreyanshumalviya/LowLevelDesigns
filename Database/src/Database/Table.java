package Database;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private String name;
    private Schema schema;
//    private Column primaryColumn;
    private List<Row> rows;

    public Table(String name, Schema schema) {
        this.name = name;
        this.schema = schema;
        this.rows = new ArrayList<>();
    }

    //    private void setPrimaryColumn(Column) throws PrimaryColumnAlreadyExistsException{
//
//    }
    public void addRow(Row row) throws SchemaNotFollowedException{
        schema.validateRow(row);
        rows.add(row);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
