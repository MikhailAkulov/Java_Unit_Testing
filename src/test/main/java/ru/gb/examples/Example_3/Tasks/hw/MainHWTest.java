package main.java.ru.gb.examples.Example_3.Tasks.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHWTest {
    MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    // HW 3.1.
    @Test
    void testIsNumberEven() {
        assertTrue(mainHW.evenOddNumber(8));
    }

    @Test
    void testIsNumberOdd() {
        assertFalse(mainHW.evenOddNumber(13));
    }

    // HW 3.2.
    @ParameterizedTest
    @ValueSource(ints = {25, 64, 100})
    void testNumberInInterval(int num) {
        assertTrue(mainHW.numberInInterval(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 24, 101})
    void testNumberOutsideInterval(int num) {
        assertFalse(mainHW.numberInInterval(num));
    }
}
