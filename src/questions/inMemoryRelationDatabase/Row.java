package questions.inMemoryRelationDatabase;

import java.util.Map;

public class Row {
  private int id;
  private Map<Column, Object> columnData;

  public Row(int id, Map<Column, Object> columnData) {
    this.id = id;
    this.columnData = columnData;
  }

  public int getId() {
    return id;
  }

  public Map<Column, Object> getColumnData() {
    return columnData;
  }

  @Override
  public String toString() {
    return "Row{" +
      "id=" + id +
      ", columnData=" + columnData +
      '}';
  }
}
