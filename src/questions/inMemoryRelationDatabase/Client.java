package questions.inMemoryRelationDatabase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {

  public static void main(String[] args) {
    DatabaseManager dbms = DBMS.getInstance();

    Database school = dbms.createDatabase("school");

    List<Column> studentTableCols = Arrays.asList(new Column("name", ColumnType.VARCHAR), new Column("age", ColumnType.INTEGER));
    Table studentsTable = school.createTable("students", studentTableCols);

    Map<Column, Object> studentDataAkhil = new HashMap<>();
    studentDataAkhil.put(new Column("name", ColumnType.VARCHAR), "Akhil");
    studentDataAkhil.put(new Column("age", ColumnType.INTEGER), "25");
    studentsTable.insertAndGetId(studentDataAkhil);

    Map<Column, Object> studentDataVaibhav = new HashMap<>();
    studentDataVaibhav.put(new Column("name", ColumnType.VARCHAR), "Vaibhav");
    studentDataVaibhav.put(new Column("age", ColumnType.INTEGER), "18");
    studentsTable.insertAndGetId(studentDataVaibhav);

    studentsTable.select(new Column("name", ColumnType.VARCHAR), "Akhil");
  }
}
