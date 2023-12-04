package main.java.ru.gb.examples.Example_4.Seminar.database;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DataProcessorTest {

    /**
     * 4.6 Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
     * Условие: У вас есть класс Database с методом public List<String> query(String sql), который выполняет SQL-
     * запрос и возвращает результат.
     * Вам необходимо проверить правильность работы класса DataProcessor, который использует Database для
     * выполнения запроса и обработки результатов.
     */
    @Test
    void testDataBase() {
        // Arrange
        Database database = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(database);
        when(database.query(anyString())).thenReturn(Arrays.asList("Data1", "Data2", "Data3"));
        // Act
        List<String> list = dataProcessor.processData("qwe");
        // Assert
        assertThat(list).isEqualTo(Arrays.asList("Data1", "Data2", "Data3"));
    }
}