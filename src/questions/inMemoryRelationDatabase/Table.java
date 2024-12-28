package questions.inMemoryRelationDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
  private String name;
  private IdGenerator idGenerator;
  private Map<String, Column> columns;
  private Map<Integer, Row> rows;

  public Table(String name, Map<String, Column> columns) {
    this.name = name;
    this.idGenerator = new IdGenerator();
    this.columns = columns;
    this.rows = new HashMap<>();
  }

  public int insertAndGetId(Map<Column, Object> values) {
    int id = idGenerator.getAndIncrement();
    Row row = new Row(id, values);
    rows.put(id, row);

    return id;
  }

  public void delete(Column identifier, Object valueToMatch) {
    checkIfColumnExist(identifier);
    List<Row> deletedRows = getSelectedRow(identifier, valueToMatch);

    System.out.println("Deleted Rows");
    for (Row row: deletedRows) {
      rows.remove(row.getId());
      System.out.println(row);
    }
  }

  public void select(Column identifier, Object valueToMatch) {
    checkIfColumnExist(identifier);
    List<Row> selectedRows = getSelectedRow(identifier, valueToMatch);
    System.out.println("Printing the selected records");
    for (Row row: selectedRows) {
      System.out.println(row);
    }
  }

  public int truncateTable() {
    int deletedRecords = rows.size();
    rows.clear();
    return deletedRecords;
  }

  private List<Row> getSelectedRow(Column identifier, Object valueToMatch) {
    List<Row> selectedRows = new ArrayList<>();
    for (Map.Entry<Integer, Row> row: rows.entrySet()) {
      Map<Column, Object> rowData = row.getValue().getColumnData();
      if (rowData.get(identifier).equals(valueToMatch)) {
        selectedRows.add(row.getValue());
      }
    }

    return selectedRows;
  }

  private void checkIfColumnExist(Column col) {
    if (!columns.containsKey(col.getName()))
      throw new IllegalStateException("Column "+col.getName()+" does not exists");
  }
}
