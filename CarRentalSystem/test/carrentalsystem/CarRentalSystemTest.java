package carrentalsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarRentalSystemTest {

    @BeforeEach
    void setUp() {
        // Clear the cars list before each test
        CarRentalSystem.cars.clear();
    }

    @Test
    void testRegisterNewCar() {
        // Mock user input for registering a new car
        String input = "ABC123\nToyota\nCorolla\n2020\nexample@example.com\n";
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        CarRentalSystem.registerNewCar();

        // Check if the car has been added
        assertEquals(1, CarRentalSystem.cars.size());
        Car car = CarRentalSystem.cars.get(0);
        assertEquals("ABC123", car.getRegistrationNumber());
        assertEquals("Toyota", car.getMake());
        assertEquals("Corolla", car.getModel());
        assertEquals(2020, car.getYear());
        assertEquals("example@example.com", car.getRenterEmail());

        // Restore the original System.in
        System.setIn(originalSystemIn);
    }

    @Test
    void testSearchCar() {
        // Add a car to the list
        CarRentalSystem.cars.add(new Car("XYZ789", "Honda", "Civic", 2019, "renter@example.com"));

        // Mock user input for searching a car
        String input = "XYZ789\n";
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Capture the output
        String output = captureOutput(() -> CarRentalSystem.searchCar());

        // Check if the car details are present in the output
        assertTrue(output.contains("CAR REGISTRATION: XYZ789"));
        assertTrue(output.contains("CAR MAKE: Honda"));
        assertTrue(output.contains("CAR MODEL: Civic"));
        assertTrue(output.contains("CAR YEAR: 2019"));
        assertTrue(output.contains("RENTER EMAIL: renter@example.com"));

        // Restore the original System.in
        System.setIn(originalSystemIn);
    }

    @Test
    void testDeleteCar() {
        // Add a car to the list
        CarRentalSystem.cars.add(new Car("LMN456", "Ford", "Focus", 2018, "test@example.com"));

        // Mock user input for deleting a car
        String input = "LMN456\ny\n";
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        CarRentalSystem.deleteCar();

        // Check if the car has been removed
        assertTrue(CarRentalSystem.cars.isEmpty());

        // Restore the original System.in
        System.setIn(originalSystemIn);
    }

    private String captureOutput(Runnable runnable) {
        // Captures the output of a Runnable method
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        runnable.run();

        System.setOut(originalOut);
        return outContent.toString();
    }
}
