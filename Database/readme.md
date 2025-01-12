[Url to editable UML](https://editor.plantuml.com/uml/ZLJRRjim37ttLn1vSeRs1rh3wDgbQ80rsDPWxupD9WPaAPFa9aRNVnzrSMmXNT40WIJoyEZmIFADiQXjrugi4cWCV4EB6pG4hndmxn7tnPFLZTnUm1etWagmRZ3NFlsYcXegJMXfHGSFo9-g7RK8nW_px2sBp3uRQHDCYFXDG69BVdsdHDTAsEkcHTs7bKzyRumjVgb32LeTZ0yPiZ-ck7mETkUoa8I_2XPQzuiZCvZ5iQAzRLGWnRfcofp_ZZMMHvKhPU-L4Ef0zLZqbfsC-d9v6NkxWja36cXHzhEXQqVvEWeFIam9LPWmKQXrB0wRSZJIadx6Yg8VnRgCRDvvRdp5XkKJy-PJDxSnFqzAVgFeA5_3Ynj3QksW8UvEp0bnWk8XlDVNKjgO3NfuJLlIWTH7M3kN73qhSuu5nT-4Uca0Pv4rw4w8Oojdl7SxrE7ucJof-u3_PqUwJud_k53YZmSDdXe_J0pSyxQKGYQNVBWLZoYHxIWC0mHP9SlpzpHWIwZZBFHpkbby9iFyjZy_wDEcNitYI5LdbOR9dh7JSCF80wBqO8Jl_VHObf9DRkh8DjxqBADXzH_CcF_WoOoWpxpAx8PaxJvB_m00)
```
@startuml
class Database {
Map<String, Table> tables;
void createNewTable(Schema schema)
}

class Table {
Schema schema
String name
Column primaryColumn
List<Row> rows
setPrimaryColumn() throws PrimaryColumnAlreadyExistsException
addRow(Row row) throw SchemaNotFollowedException
}
Database *-- Table : "Has many"

class Row {
List<Columns> columns
}
Table *-- Row : "Has many"

interface Column<T> {
void setName(String name)
String getName()
void setValue(T value)
T getValue()
}
Row *-- Column : "Has many"

class IntColumn {
Integer value
int maxValue
}
IntColumn <|-- Column : "Is a"
class StringColumn {
String value
int maxChars

}
StringColumn <|-- Column : "Is a"
class Query {
String query
void setQuery(String string)
void parseQuery(String s)
}

class DatabaseManager<singleton>{
Map<String, Database> databases
Database getDatabaseByName(String name)
}

class QueryExecutor <singleton> {
Table executeQuery(Query query) throws InvalidQueryException
}


exception InvalidQueryException
exception SchemaNotFollowedException
exception PrimaryColumnAlreadyExistsException

@enduml
```