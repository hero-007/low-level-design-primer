package questions.inMemoryRelationDatabase;

import java.util.Objects;

public class Column {
  private String name;
  private ColumnType type;

  public Column(String name, ColumnType type) {
    this.name = name;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public ColumnType getType() {
    return type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Column)) return false;
    Column column = (Column) o;
    return Objects.equals(getName(), column.getName()) && getType() == column.getType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getType());
  }
}
