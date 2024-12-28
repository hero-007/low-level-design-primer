package questions.inMemoryRelationalDatabaseV2.databaseManager;

public class DatabaseManagerFactory {

  public DatabaseManager build(DatabaseManagerType type) {
    if (type == DatabaseManagerType.SQL)
      return new RelationalDatabaseManager();
    else if(type == DatabaseManagerType.NOSQL)
      return new NoSQLDatabaseManager();
    else throw new IllegalStateException("Unknown database manager type "+type.name());

  }
}
