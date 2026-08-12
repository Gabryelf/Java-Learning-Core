package seminars.second.hw;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class VehicleTest {

    @Test
    void testCarInstanceIsVehicle() {
        Car car = new Car("Toyota", "Camry", 2022);
        assertThat(car).isInstanceOf(Vehicle.class);
    }

    @Test
    void testCarHasFourWheels() {
        Car car = new Car("Toyota", "Camry", 2022);
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    void testMotorcycleHasTwoWheels() {
        Motorcycle motorcycle = new Motorcycle("Honda", "CBR", 2022);
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    @Test
    void testCarTestDriveSpeed() {
        Car car = new Car("Toyota", "Camry", 2022);
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void testMotorcycleTestDriveSpeed() {
        Motorcycle motorcycle = new Motorcycle("Honda", "CBR", 2022);
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    void testCarPark() {
        Car car = new Car("Toyota", "Camry", 2022);
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void testMotorcyclePark() {
        Motorcycle motorcycle = new Motorcycle("Honda", "CBR", 2022);
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}

