package main.java.ru.gb.examples.Example_4.Seminar.webService;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WebServiceTest {

    /**
     * 4.7 Вам нужно написать тест с использованием моков для класса, который выполняет HTTP-запросы.
     * Условие: У вас есть класс HttpClient с методом public String get(String url),
     * который выполняет HTTP-запрос и возвращает результат.
     * Вам необходимо проверить правильность работы класса WebService,
     * который использует HttpClient для получения данных с веб-сайта.
     */

    @Test
    void testRequestHttpClient() {
        // Arrange
        MyHttpClient myHttpClient = mock(MyHttpClient.class);
        WebService webService = new WebService(myHttpClient);
        when(myHttpClient.get(anyString())).thenReturn("ok");
        // Act
        String result = webService.sendRequest("url");
        // Assert
        assertThat(result).isEqualTo("ok");
    }
}
