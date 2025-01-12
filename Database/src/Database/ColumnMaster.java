package Database;

import java.util.HashMap;

public class ColumnMaster {

    private static ColumnMaster columnMaster;

    public static ColumnMaster getInstance() {
        if (columnMaster == null) columnMaster = new ColumnMaster();
        return columnMaster;
    }

    private ColumnMaster() {
        columnTypeClassHashMap = new HashMap<>();
        columnTypeClassHashMap.put(ColumnType.INT_COLUMN, IntColumn.class);
        columnTypeClassHashMap.put(ColumnType.STRING_COLUMN, StringColumn.class);
    }

    HashMap<ColumnType, Class> columnTypeClassHashMap;

}
