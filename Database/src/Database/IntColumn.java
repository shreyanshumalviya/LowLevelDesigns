package Database;

public class IntColumn implements Column<Integer>{
    private String name;
    private Integer value;

    public IntColumn(String name, Integer value) {
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
    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.INT_COLUMN;
    }

}
