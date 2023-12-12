package main.java.ru.gb.examples.Example_5.Seminar;

import main.java.ru.gb.examples.Example_5.Seminar.number.MaxNumberModule;
import main.java.ru.gb.examples.Example_5.Seminar.number.RandomNumberModule;
import main.java.ru.gb.examples.Example_5.Seminar.order.OrderService;
import main.java.ru.gb.examples.Example_5.Seminar.order.PaymentService;
import main.java.ru.gb.examples.Example_5.Seminar.user.UserRepository;
import main.java.ru.gb.examples.Example_5.Seminar.user.UserService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    /**
     * 5.1. Создайте два модуля.
     * Первый модуль генерирует список случайных чисел.
     * Второй модуль находит максимальное число в этом списке.
     * Вам нужно сначала написать юнит-тесты для каждого модуля, затем написать интеграционный тест,
     * который проверяет, что оба модуля работают вместе правильно
     */
    @Test
    void testRandomGen() {
        RandomNumberModule rnm = new RandomNumberModule();
        ArrayList<Integer> array = rnm.getList(5);
        assertThat(array.size()).isEqualTo(5);
    }

    @Test
    void testFindMaxNumberFromList() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        MaxNumberModule maxNumber = new MaxNumberModule();
        assertThat(maxNumber.getMaxValue(array)).isEqualTo(5);
    }

    @Test
    void integrationTest() {
        RandomNumberModule rnm = new RandomNumberModule();
        ArrayList<Integer> array = rnm.getList(5);
        MaxNumberModule maxNumber = new MaxNumberModule();

        assertThat(maxNumber.getMaxValue(array)).isEqualTo(Collections.max(array));
    }

    /**
     * 5.2. У вас есть два класса - UserService и UserRepository.
     * UserService использует UserRepository для получения информации о пользователе.
     * Ваша задача - написать интеграционный тест, который проверяет,
     * что UserService и UserRepository работают вместе должным образом.
     */
    @Test
    void integrationTestForUser() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        String result = userService.getUserName(1);

        assertThat(result).isEqualTo("User " + 1);
    }

    /**
     * 5.3. У вас есть сервис по обработке заказов, состоящий из двух классов: OrderService и PaymentService.
     * Класс OrderService обрабатывает заказы и делает вызовы к PaymentService для обработки платежей.
     * Ваша задача - написать интеграционный тест, который проверяет,
     * что OrderService и PaymentService взаимодействуют корректно
     */
    @Test
    void integrationTestForOrder() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean result = orderService.placeOrder("1", 100);

        assertTrue(result);
    }
}