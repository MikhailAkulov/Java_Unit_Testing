import org.junit.jupiter.api.Test;
import ru.gb.examples.Example_2.Lecture.Calculator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void evaluatesExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2, 6, '+')).isEqualTo(8);
    }

    @Test
    void substractionExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2, 1, '-')).isEqualTo(1);
    }

    @Test
    void multiplicationExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2, 4, '*')).isEqualTo(8);
    }

    @Test
    void divisionExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(8, 2, '/')).isEqualTo(4);
    }

    @Test
    void expectedIllegalStateExceptionOnInvalidOperatorSymbol () {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculation(8,4,'_'))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void getOperandCompletesCorrectlyWithNumbers() {
        String testedValue = "9"; // Значение для тестов
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        InputStream inputStream = System.in; // Сохраняем ссылку на ввод с клавиатуры
        System.setIn(in); // Подменяем ввод

        Calculator.getOperand(); // Вызываем метод

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

        assertThatThrownBy(() -> Calculator.getOperand()).isInstanceOf(IllegalStateException.class).
                describedAs("Ошибка в вводимых данных");

        System.setIn(inputStream);
        System.setOut(null);
    }
}
