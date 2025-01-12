package Database;

public class Constraint {
    private ColumnType columnType;
    private int limit;

    private boolean nullable;


    public Constraint(ColumnType columnType, int limit) {
        this.columnType = columnType;
        this.limit = limit;
    }

    public boolean columnCheck(Column column) throws SchemaNotFollowedException {
        if (!nullable && column == null)
            throw new SchemaNotFollowedException();
        if (nullable && column == null)
            return true;
        if (this.columnType != column.getColumnType()) {
            throw new SchemaNotFollowedException();
        }
        ;
        if (columnType == ColumnType.INT_COLUMN && ((IntColumn) column).getValue() > limit) {
            throw new SchemaNotFollowedException();
        }
        if (columnType == ColumnType.STRING_COLUMN && ((StringColumn) column).getValue().length() > limit) {
            throw new SchemaNotFollowedException();
        }
        return true;
    }
}
