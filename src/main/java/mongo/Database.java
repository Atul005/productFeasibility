package mongo;/*
 * @author atulyadav on 2019-08-27 16:12
 *
 * types of dbs in mongo
 */

public enum Database {

    PRODUCT_STORE("productStore"),
    GLOBAL_STORE("global");

    public String getDbName() {
        return dbName;
    }

    private String dbName;

    Database(String dbName) {
        this.dbName = dbName;
    }
}
