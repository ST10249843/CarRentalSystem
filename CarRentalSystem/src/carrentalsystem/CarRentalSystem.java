package carrentalsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class CarRentalSystem 
{
    static ArrayList<Car> cars = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
         System.out.println("CAR RENTAL MANAGEMENT APPLICATION");
        while (true)
        {
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String input = scanner.nextLine();
            if (!input.equals("1")) 
            {
                break;
            }

            displayMenu();
        }
    }

    public static void displayMenu() 
    {
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Register a new car.");
        System.out.println("(2) Search for a car.");
        System.out.println("(3) Delete a car.");
        System.out.println("(4) Print car report.");
        System.out.println("(5) Exit Application.");
                
        String choice = scanner.nextLine();
        switch (choice) 
        {
            case "1":
                registerNewCar();
                break;
            case "2":
                searchCar();
                break;
            case "3":
                deleteCar();
                break;
            case "4":
                printCarReport();
                break;
            case "5":
                exitApplication();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void registerNewCar() 
    {
        System.out.println("REGISTER A NEW CAR");

        System.out.print("Enter the car registration number: ");
        String registrationNumber = scanner.nextLine();

        System.out.print("Enter the car make: ");
        String make = scanner.nextLine();

        System.out.print("Enter the car model: ");
        String model = scanner.nextLine();

        int year;
        while (true) 
        {
            try 
            {
                System.out.print("Enter the car year: ");
                year = Integer.parseInt(scanner.nextLine());
                if (year >= 1886) 
                { 
                    break;
                } 
                else 
                {
                    System.out.println("You have entered an incorrect car year!!! Please re-enter the car year >>");
                }
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("You have entered an incorrect car year!!! Please re-enter the car year >>");
            }
        }

        System.out.print("Enter the renter's email: ");
        String renterEmail = scanner.nextLine();

        cars.add(new Car(registrationNumber, make, model, year, renterEmail));
        System.out.println("Car details have been successfully saved.");
    }

    public static void searchCar() 
    {
        System.out.print("Enter the car registration number to search: ");
        String registrationNumber = scanner.nextLine();

        for (Car car : cars) 
        {
            if (car.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) 
            {
                System.out.println(car);
                return;
            }
        }

        System.out.println("Car with registration number " + registrationNumber + " was not found!");
    }

    public static void deleteCar() 
    {
        System.out.print("Enter the car registration number to delete: ");
        String registrationNumber = scanner.nextLine();

        for (Car car : cars) 
        {
            if (car.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) 
            {
                System.out.print("Are you sure you want to delete car " + registrationNumber + " from the system? Yes (y) to delete: ");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("y")) 
                {
                    cars.remove(car);
                    System.out.println("Car with registration number " + registrationNumber + " WAS deleted!");
                } 
                else 
                {
                    System.out.println("Deletion cancelled.");
                }
                return;
            }
        }

        System.out.println("Car with registration number " + registrationNumber + " was not found!");
    }

    public static void printCarReport() 
    {
        if (cars.isEmpty()) 
        {
            System.out.println("No cars registered in the system.");
        } 
        else
        {
            int count = 1;
            for (Car car : cars)
            {
                System.out.println("CAR " + count++);
                System.out.println(car);
            }
        }
    }

    public static void exitApplication() {
        System.out.println("Exiting application...");
        System.exit(0);
    }
}
