package questions.inMemoryRelationalDatabaseV2.database;

public class DatabaseFactory {

  public static Database build(DatabaseType type) {
    if (type == DatabaseType.RELATIONAL)
      return new RelationalDatabase();
    else if(type == DatabaseType.NON_RELATIONAL)
      return new NonRelationalDatabase();
    else throw new IllegalStateException("Unknown database type "+type.name());
  }

}
