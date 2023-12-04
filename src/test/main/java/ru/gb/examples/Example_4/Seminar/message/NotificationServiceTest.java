package main.java.ru.gb.examples.Example_4.Seminar.message;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class NotificationServiceTest {

    /**
     * 4.5 Вам нужно написать тест с использованием моков для сервиса отправки сообщений.
     * Условие: У вас есть класс MessageService с методом public void sendMessage(String message, String
     * recipient), который отправляет сообщение получателю.
     * Вам необходимо проверить правильность работы класса NotificationService, который использует
     * MessageService для отправки уведомлений.
     */

    @Test
    void testNotificationService() {
        // Arrange
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageService);
        // Act
        notificationService.sendNotification("Hello", "all");
        // Assert
        verify(messageService, times(1)).sendMessage("Hello", "all");
    }
}