package questions.inMemoryRelationalDatabaseV2.databaseManager;

import questions.inMemoryRelationalDatabaseV2.database.Database;

public interface DatabaseManager {
  Database createDatabase(String name);
  void dropDatabase(String name);
}
