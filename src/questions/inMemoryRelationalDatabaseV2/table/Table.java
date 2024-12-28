package questions.inMemoryRelationalDatabaseV2.table;

import questions.inMemoryRelationalDatabaseV2.data.Column;
import questions.inMemoryRelationalDatabaseV2.data.Row;
import questions.inMemoryRelationalDatabaseV2.filters.Filter;

import java.util.List;

public interface Table {
  List<Row> select(Column column, Filter filter, Object value);
  List<Row> delete(Column column, Filter filter, Object value);
  Integer insert(Row row);
}
