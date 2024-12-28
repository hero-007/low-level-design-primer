package questions.inMemoryRelationDatabase;

import java.util.HashMap;
import java.util.Map;

public class DBMS implements DatabaseManager {
  private static DBMS dbms;
  private Map<String, Database> databases;

  private DBMS() {
    databases = new HashMap<>();
  }

  public static DBMS getInstance() {
    if (dbms == null) {
      dbms = new DBMS();
    }

    return dbms;
  }

  public Database createDatabase(String name) {
    if (databases.containsKey(name))
      throw new IllegalStateException("Database "+name+" already exist");

    Database db = new Database(name);
    databases.put(name, db);
    return db;
  }

  public void dropDatabase(String name) {
    if (!databases.containsKey(name))
      throw new IllegalStateException("Database "+name+" does not exist");

    databases.remove(name);
  }

}
