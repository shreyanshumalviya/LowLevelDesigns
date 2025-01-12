package Database;

import java.util.Map;

public class Row {
    private Map<String, Column> columns;

    public Row(Map<String, Column> columns) {
        this.columns = columns;
    }


    public Map<String, Column> getColumns() {
        return columns;
    }
}
