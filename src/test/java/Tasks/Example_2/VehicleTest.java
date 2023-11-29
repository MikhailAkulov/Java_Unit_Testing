package Tasks.Example_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gb.examples.Example_2.Tasks.Car;
import ru.gb.examples.Example_2.Tasks.Motorcycle;
import ru.gb.examples.Example_2.Tasks.Vehicle;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        car = new Car("Subaru", "Impreza_WRX_STI", 2012);
        motorcycle = new Motorcycle("Ducati", "Monster_1200", 2016);
    }

    /**
     * 1. проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
     */
    @Test
    public void testCarIsInstanceOfVechicle() {
        assertTrue(car instanceof Vehicle);
    }

    /**
     * 2. проверка того, объект Car создается с 4-мя колесами
     */
    @Test
    public void correctNumberOfWheelsCar(){
        assertEquals(4, car.getNumWheels());
    }

    /**
     * 3. проверка того, объект Motorcycle создается с 2-мя колесами
     */
    @Test
    public void correctNumberOfWheelsMotorcycle(){
        assertEquals(2, motorcycle.getNumWheels());
    }

    /**
     * 4. проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
     */
    @Test
    public void checkingCarSpeedInTestDriveMode() {
        // Act (Выполнение)
        car.testDrive();
        // Assert (Проверка утверждения)
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    /**
     * 5. проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
     */
    @Test
    public void checkingMotorcycleSpeedInTestDriveMode() {
        // Act (Выполнение)
        motorcycle.testDrive();
        // Assert (Проверка утверждения)
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    /**
     * 6. проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина
     * останавливается (speed = 0)
     */
    @Test
    public void checkingCarSpeedInParkMode() {
        // Act (Выполнение)
        car.testDrive();
        car.park();
        // Assert (Проверка утверждения)
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    /**
     * 7. проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл
     * останавливается (speed = 0)
     */
    @Test
    public void checkingMotorcycleSpeedInParkMode() {
        // Act (Выполнение)
        motorcycle.testDrive();
        motorcycle.park();
        // Assert (Проверка утверждения)
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}