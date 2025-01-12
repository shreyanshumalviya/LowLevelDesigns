package Database;

public interface Column<T>{
    void setName(String name);
    String getName();
    void setValue(T value);
    T getValue();

    ColumnType getColumnType();
}
