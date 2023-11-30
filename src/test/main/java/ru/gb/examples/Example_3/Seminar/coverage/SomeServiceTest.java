package main.java.ru.gb.examples.Example_3.Seminar.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    SomeService someService;
    int[] numList;

    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }

   // 3.1.
    @Test
    void multipleThreeNotFiveReturnsFizz() {
        String check = someService.fizzBuzz(3);
        assertThat(check).isEqualTo("Fizz");
    }

    @Test
    void multipleFiveNotThreeReturnsBuzz() {
        String check = someService.fizzBuzz(5);
        assertThat(check).isEqualTo("Buzz");
    }

    @Test
    void multipleThreeOrFiveReturnsFizzBuzz() {
        String check = someService.fizzBuzz(15);
        assertThat(check).isEqualTo("FizzBuzz");
    }

    @Test
    void multipleNotThreeOrFiveReturnsNumber() {
        String check = someService.fizzBuzz(7);
        assertThat(check).isEqualTo("7");
    }

    // 3.2.
    @Test
    void testArrayCellValue6() {
        boolean result = someService.firstLast6(new int[]{1, 2, 3, 4, 5, 6});
        assertTrue(result);
    }

    @Test
    void testArrayCellValueNot6() {
        boolean result = someService.firstLast6(new int[]{1, 2, 3, 4, 5, 7});
        assertFalse(result);
    }

    // 3.3.
    @ParameterizedTest
    @CsvSource({"2000, 50, 1000", "2000, 100, 0", "2000, 0, 2000"})
    void insufficientCoverageTest(double purchaseAmount, int discountAmount, double result) {
        assertThat(someService.calculatingDiscount(purchaseAmount, discountAmount))
                .isEqualTo(result); // обычная скидка
    }

    @Test
    void testOverDraftPercentDiscount() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%
    }

    @Test
    void testNegativePercentDiscount() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки меньше 0
    }

    @Test
    void testNegativePurchaseAmount() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(-1000.0, 50))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной"); // сумма покупки меньше 0
    }

    // 3.4.
    @Test
    void testPositiveLuckySum() {
        assertThat(someService.luckySum(10, 11, 12)).isEqualTo(33);
    }

    @ParameterizedTest
    @CsvSource({"13, 10, 11, 21", "10, 13, 11, 21", "10, 11, 13, 21"})
    void testNegativeLuckySum(int a, int b, int c, int result) {
        assertThat(someService.luckySum(a, b, c)).isEqualTo(result);
    }
}