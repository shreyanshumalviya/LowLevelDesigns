package Database;

import javax.xml.crypto.Data;

public class QueryExecutor {
    private static QueryExecutor queryExecutor;

    public QueryExecutor getInstance(){
        if(queryExecutor == null) queryExecutor = new QueryExecutor();// create connection
        return queryExecutor;
    }

    Table executeQuery(Query query){
        var database = DatabaseManager.getInstance().getDatabaseByName(query.getUse());
        if (database == null) {
            // todo throw error
            return null;
        }
        database.getTableByName(query.getFrom());

        return null;
    }

}
