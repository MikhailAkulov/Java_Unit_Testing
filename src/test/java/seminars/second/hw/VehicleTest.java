package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gb.examples.Example_2.Seminar.hw.Car;
import ru.gb.examples.Example_2.Seminar.hw.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("dodge", "Ram", 2010);
    }

    @Test
    public void testCarIsInstanceOfVechicle() {
        assertTrue(car instanceof Vehicle);
    }
}