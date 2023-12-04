package main.java.ru.gb.examples.Example_4.Seminar.hotel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    /**
     * 4.4 Вам необходимо написать тест с использованием моков для сервиса бронирования отелей.
     * Условие: У вас есть класс HotelService с методом public boolean isRoomAvailable(int roomId),
     * который обычно проверяет, доступен ли номер в отеле.
     * Вам необходимо проверить правильность работы класса BookingService, который
     * использует HotelService для бронирования номера, если он доступен.
     */

    @Test
    void testBookingPositive() {
        // Arrange
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(bookingService.bookRoom(4)).thenReturn(true);
        // Act
        boolean result = bookingService.bookRoom(4);
        // Assert
        assertTrue(result);
    }

    @Test
    void testBookingNegative() {
        // Arrange
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(bookingService.bookRoom(3)).thenReturn(false);
        // Act
        boolean result = bookingService.bookRoom(3);
        // Assert
        assertFalse(result);
    }
}