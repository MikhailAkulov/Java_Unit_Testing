package main.java.ru.gb.examples.Example_4.Seminar.database;

import java.util.List;

public class DataProcessor {
    private Database database;

    public DataProcessor(Database database) {
        this.database = database;
    }

    public List<String> processData(String sql) {
        return database.query(sql);
    }
}
