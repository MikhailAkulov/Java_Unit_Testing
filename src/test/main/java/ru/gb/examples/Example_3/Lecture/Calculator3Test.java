package main.java.ru.gb.examples.Example_3.Lecture;

import main.java.ru.gb.examples.Example_2.Lecture.Calculator2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Calculator3Test {
    /**
     * Лекция 2
     */
    @Test
    void evaluatesExpression() {
        Calculator2 calculator2 = new Calculator2();
        assertThat(calculator2.calculation(2, 6, '+')).isEqualTo(8);
    }

    @Test
    void subtractionExpression() {
        Calculator2 calculator2 = new Calculator2();
        assertThat(calculator2.calculation(2, 1, '-')).isEqualTo(1);
    }

    @Test
    void multiplicationExpression() {
        Calculator2 calculator2 = new Calculator2();
        assertThat(calculator2.calculation(2, 4, '*')).isEqualTo(8);
    }

    @Test
//    @Disabled
    void divisionExpression() {
        Calculator2 calculator2 = new Calculator2();
        assertThat(calculator2.calculation(8, 2, '/')).isEqualTo(4);
    }

    @Test
    void expectedIllegalStateExceptionOnInvalidOperatorSymbol () {
        Calculator2 calculator2 = new Calculator2();
        assertThatThrownBy(() -> calculator2.calculation(8,4,'_'))
                .isInstanceOf(IllegalStateException.class);
    }

    // <-------JUnit-Jupiter-Params
    @ParameterizedTest
    @ValueSource(chars = { '&', '#', '=' })
    void expectedIllegalStateExpressionToo(char i) {
        // Arrange
        Calculator2 calculator2 = new Calculator2();
        char o = i;

        // Act
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            calculator2.calculation(8, 4, o);
        });

        // Assert
        String expectedMessage = "Unexpected value operator: " + o;
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void getOperandCompletesCorrectlyWithNumbers() {
        String testedValue = "9"; // Значение для тестов
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        InputStream inputStream = System.in; // Сохраняем ссылку на ввод с клавиатуры
        System.setIn(in); // Подменяем ввод

        Calculator2.getOperand(); // Вызываем метод

        System.out.println(testedValue); // Для наглядности вывода
        System.setIn(inputStream); // Подменяем обратно
    }

    @Test
    void getOperandCompletesCorrectlyWithNotNumbers() {
        String testedValue = "k";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream inputStream = System.in;
        System.setIn(in);
        System.setOut(new PrintStream(out));

        assertThatThrownBy(() -> Calculator2.getOperand())
                .isInstanceOf(IllegalStateException.class).
                describedAs("Ошибка в вводимых данных");

        System.setIn(inputStream);
        System.setOut(null);
    }

    /**
     * Лекция 3
     */
    // создаем тест для метода вычисления радиуса круга по принципу TDD (сначала тест, потом метод)
    @Test
    void computeCircleRadiusWorksCorrectly() {
        assertThat(Calculator3.computeAreaCircle(10)).isEqualTo(314.1592653589793);
    }

    //HW3.1L: Попробуйте реализовать в калькуляторе с помощью методологии TDD (с описанием шагов) функцию расчета длины окружности
    // P=2πR
    @Test
    void computeLengthCircleWithRadius() {
        Calculator3 calculator3 = new Calculator3();
        assertThat(calculator3.computeLengthCircle(10)).isEqualTo(62.83185307179586);
        assertTrue(Math.abs(62 - calculator3.computeLengthCircle(10)) < 1);
    }

    @Test
    void computeLengthCircleWithDiameter() {
        // Arrange
        FigureCalc calculator = new FigureCalc();
        // Act
        double result = calculator.calculate(20);
        // Assert
        assertEquals(62.83185307179586, result);
    }
}
