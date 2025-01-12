package Database;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Query {
    private final String query;
    private String use;
    private String from;
    private List<String> select;
    private Map<String, Objects> where;

    public Query(String query) {
        this.query = query;
    }

    public String getQuery(){
        return this.query;
    }

    public String getUse() {
        return use;
    }

    public String getFrom() {
        return from;
    }

    public List<String> getSelect() {
        return select;
    }

    public Map<String, Objects> getWhere() {
        return where;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setSelect(List<String> select) {
        this.select = select;
    }

    public void setWhere(Map<String, Objects> where) {
        this.where = where;
    }
}
