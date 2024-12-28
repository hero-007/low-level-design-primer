package questions.inMemoryRelationalDatabaseV2.database;

import questions.inMemoryRelationalDatabaseV2.table.Table;

public interface Database {
  Table createTable(String name);
  void dropTable(String name);
}
