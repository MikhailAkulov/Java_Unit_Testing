package main.java.ru.gb.examples.Example_4.Seminar.weather;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherReporterTest {

    /**
     * 4.3 Предположим, у вас есть класс WeatherService, который имеет метод getCurrentTemperature(),
     * обращающийся к внешнему API для получения информации о текущей температуре.
     * Вам нужно протестировать другой класс, WeatherReporter, который использует WeatherService.
     * Создайте мок-объект для WeatherService с использованием Mockito.
     */
    @Test
    void testGenerateReport() {
        // Arrange
        WeatherService weatherService = mock(WeatherService.class);
        WeatherReporter weatherReporter = new WeatherReporter(weatherService);
        when(weatherService.getCurrentTemperature()).thenReturn(25);
        // Act
        String result = weatherReporter.generateReport();
        // Assert
        assertEquals("Текущая температура: " + 25 + " градусов.", result);
    }
}