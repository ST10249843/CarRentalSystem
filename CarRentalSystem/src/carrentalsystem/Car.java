package carrentalsystem;

public class Car 
{
    private String registrationNumber;
    private String make;
    private String model;
    private int year;
    private String renterEmail;

    public Car(String registrationNumber, String make, String model, int year, String renterEmail) 
    {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.renterEmail = renterEmail;
    }

    public String getRegistrationNumber() 
    {
        return registrationNumber;
    }

    public String getMake()
    {
        return make;
    }

    public String getModel() 
    {
        return model;
    }

    public int getYear() 
    {
        return year;
    }

    public String getRenterEmail() 
    {
        return renterEmail;
    }

    @Override
    public String toString() 
    {
        return "CAR REGISTRATION: " + registrationNumber + "\n" +
                "CAR MAKE: " + make + "\n" +
                "CAR MODEL: " + model + "\n" +
                "CAR YEAR: " + year + "\n" +
                "RENTER EMAIL: " + renterEmail + "\n";
    }
}
