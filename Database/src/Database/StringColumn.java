package Database;

public class StringColumn implements Column<String> {
    private String name;
    private String value;

    public StringColumn(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.STRING_COLUMN;
    }
}