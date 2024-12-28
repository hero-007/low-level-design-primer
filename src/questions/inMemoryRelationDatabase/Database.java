package questions.inMemoryRelationDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Database implements TableManager {
  private String name;
  private Map<String, Table> tables;

  public Database(String name) {
    this.name = name;
    this.tables = new HashMap<>();
  }

  public Table createTable(String name, List<Column> columns) {
    if (tables.containsKey(name))
      throw new IllegalStateException("Table "+name+" already exists");

    Map<String, Column> columnMap = columns.stream().collect(Collectors.toMap(Column::getName, c -> c));
    columnMap.put("id", new Column("id", ColumnType.INTEGER));

    Table table = new Table(name, columnMap);

    tables.put(name, table);
    return table;
  }

  public void dropTable(String name) {
    if (!tables.containsKey(name))
      throw new IllegalStateException("Table "+name+" does not exists");

    tables.remove(name);
  }

}
