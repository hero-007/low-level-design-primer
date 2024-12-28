package questions.inMemoryRelationalDatabaseV2.table;

import questions.inMemoryRelationalDatabaseV2.data.Column;
import questions.inMemoryRelationalDatabaseV2.data.Row;
import questions.inMemoryRelationalDatabaseV2.filters.Filter;

import java.util.List;

public class RelationalTable implements Table {
  @Override
  public List<Row> select(Column column, Filter filter, Object value) {
    return null;
  }

  @Override
  public List<Row> delete(Column column, Filter filter, Object value) {
    return null;
  }

  @Override
  public Integer insert(Row row) {
    return null;
  }
}
