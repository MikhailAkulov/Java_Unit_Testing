package main.java.ru.gb.examples.Example_1.Tasks.Calculator;

import main.java.ru.gb.examples.Example_1.Tasks.Calculator.Calculator;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {
        System.out.println(Calculator.squareRootExtraction(169));
        assertThatThrownBy(() -> Calculator.squareRootExtraction(-169)).isInstanceOf(IllegalArgumentException.class);

        assertThat(Calculator.calculatingDiscount(100,20)).isEqualTo(80);
        assertThat(Calculator.calculatingDiscount(5.0, 2.0)).isEqualTo(4.9);
        assertThat(Calculator.calculatingDiscount(0, 10)).isEqualTo(0);
        assertThat(Calculator.calculatingDiscount(-500, 30)).isEqualTo(-350);
        assertThat(Calculator.calculatingDiscount(450, 0)).isEqualTo(450);
        assertThat(Calculator.calculatingDiscount(450, 100)).isEqualTo(0);
        assertThat(Calculator.calculatingDiscount(200, -20)).isEqualTo(240);
        assertThat(Calculator.calculatingDiscount(100, 150)).isEqualTo(-50);
    }
}