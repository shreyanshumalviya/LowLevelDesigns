package Database;

import java.util.Map;

public class Schema {
    Map<String, Constraint> schema;

    public Schema(Map<String, Constraint> schema) {
        this.schema = schema;
    }

    public void validateRow(Row row) throws SchemaNotFollowedException {
        for(var col: schema.entrySet()){
            if(!col.getValue().columnCheck(row.getColumns().get(col.getKey()))){
                throw new SchemaNotFollowedException();
            }
        }

    }
}
