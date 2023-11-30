package main.java.ru.gb.examples.Example_1.Lecture;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {
        // Проверка базового функционала с целыми числами:
//        if (4 != Calculator.calculation(2, 2, '+')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//
//        if (2 != Calculator.calculation(4, 2, '-')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//
//        if (4 != Calculator.calculation(8, 2, '/')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//
//        if (6 != Calculator.calculation(3, 2, '*')) {
//            throw new AssertionError("Ошибка в методе");
//        }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
//        assert 4 == Calculator.calculation(2, 2, '+');
//        assert 2 == Calculator.calculation(4, 2, '-');
//        assert 4 == Calculator.calculation(8, 2, '/');
//        assert 9 == Calculator.calculation(3, 2, '*');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        assertThat(Calculator.calculation(2, 2, '+')).isEqualTo(4);
        assertThat(Calculator.calculation(4, 2, '-')).isEqualTo(2);
        assertThat(Calculator.calculation(8, 2, '/')).isEqualTo(4);
        assertThat(Calculator.calculation(3, 2, '*')).isEqualTo(6);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
        assertThatThrownBy(() -> Calculator.calculation(8, 4, '_'))
                .isInstanceOf(IllegalStateException.class);

//        System.out.println(Calculator.calculation(2_147_483_647, 1, '+')); // integer overflow
//        System.out.println(Calculator.squareRootExtraction(169));

        // Случаи с неправильными аргументами
//        try {
//            Calculator.calculation(8, 4, '_');
//        } catch (IllegalStateException e) {
//            if (!e.getMessage().equals("Unexpected value operator: _")) {
//                throw new AssertionError("Ошибка в методе");
//            }
//        }

        // Примерные решения домашних заданий из 1 лекции:
        // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
        // необходимые проверки для него используя граничные случаи
//         assertThatThrownBy(() ->
//                 Calculator.squareRootExtraction(0, 1, -1)
//         ).isInstanceOf(SomeStateException.class);

        // HW1.2: Как будет выглядеть проверка для случая деления на ноль? (с использованием AssertJ)
//         assertThatThrownBy(() ->
//                Calculator.calculation(5, 0, '/')
//         ).isInstanceOf(ArithmeticException.class);

        // HW1.3: Сравните одну и ту же проверку с использованием условий, ассертов, AssertJ
        // в каком случае стандартное сообщение об ошибке будет более информативным?
//         if (0 != Calculator.calculation(2, 6, '+')) {
//             throw new AssertionError("Ошибка в методе");
//         }
//           assert 0 == Calculator.calculation(2, 6, '+');
//            assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(0);
    }
}
