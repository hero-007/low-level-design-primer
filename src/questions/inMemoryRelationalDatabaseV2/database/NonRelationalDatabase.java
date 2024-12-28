package questions.inMemoryRelationalDatabaseV2.database;

import questions.inMemoryRelationalDatabaseV2.table.Table;

public class NonRelationalDatabase implements Database{

  @Override
  public Table createTable(String name) {
    return null;
  }

  @Override
  public void dropTable(String name) {

  }
}
