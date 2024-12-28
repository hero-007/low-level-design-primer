package questions.inMemoryRelationDatabase;

public interface DatabaseManager {
  Database createDatabase(String name);
  void dropDatabase(String name);
}
