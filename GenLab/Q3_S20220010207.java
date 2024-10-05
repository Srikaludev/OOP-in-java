abstract class Vehicle {
    private String make;
    private String model;
    private int year;
    private String fuelType;
    private double fuelEfficiency;

    public Vehicle(String make, String model, int year, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        calculateFuelEfficiency();
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getFuel() {
        return fuelType;
    }

    abstract public int distanceTravelled();

    abstract public int maxSpeed();

    abstract public double calculateFuelEfficiency();
}

class Truck extends Vehicle {
    private double cargoCapacity;

    public Truck(String make, String model, int year, String fuelType, double cargoCapacity) {
        super(make, model, year, fuelType);
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public int distanceTravelled() {
        // Implement distance calculation for a truck
        return 50000; // Placeholder value
    }

    @Override
    public int maxSpeed() {
        if(cargoCapacity>10){
            return 80;
        }
        else{
            return 110;
        }
    }

    @Override
    public double calculateFuelEfficiency() {
        // Implement fuel efficiency calculation for a truck
        return 8.5; // Placeholder value (miles per gallon)
    }
}

class Car extends Vehicle {
    private int numSeats;

    public Car(String make, String model, int year, String fuelType, int numSeats) {
        super(make, model, year, fuelType);
        this.numSeats = numSeats;
    }

    public int getNumSeats() {
        return numSeats;
    }

    @Override
    public int distanceTravelled() {
        return 30000; // Placeholder value
    }

    @Override
    public int maxSpeed() {
        return 220; // Placeholder value
    }

    @Override
    public double calculateFuelEfficiency() {
        return 25.5; // Placeholder value (kilometers per liter)
    }
}

class Motorcycle extends Vehicle {
    private double engineDisplacement;

    public Motorcycle(String make, String model, int year, String fuelType, double engineDisplacement) {
        super(make, model, year, fuelType);
        this.engineDisplacement = engineDisplacement;
    }

    public double getEngineDisplacement() {
        return engineDisplacement;
    }

    @Override
    public int distanceTravelled() {
        if(engineDisplacement>2000){
        return 1500;}
        else{
            return 5000;
        } // Placeholder value
    }

    @Override
    public int maxSpeed() {
        // Implement max speed for a motorcycle
        return 150; // Placeholder value
    }

    @Override
    public double calculateFuelEfficiency() {
    if(engineDisplacement<1000){
       return 50.0; // Placeholder value (miles per gallon)
    }
    else if(engineDisplacement>1000 &&engineDisplacement<2000){
        return 30.0;
    }
    else{
        return 25.5;
    }
}
}
public class Q3_S20220010207 {
    public static void main(String args[]) {
        Car c = new Car("MercedesBenz", "SLS", 2021, "Petrol", 2);
        Motorcycle m = new Motorcycle("IndianMotorcycles", "Roadmaster", 2022, "Petrol", 1898);
        Truck t = new Truck("Ford", "Raptor", 2015, "Diesel", 4);

        // Calculate and display information for each vehicle
        displayVehicleInfo(c);
        displayVehicleInfo(m);
        displayVehicleInfo(t);
    }

    public static void displayVehicleInfo(Vehicle vehicle) {
        System.out.println("Make: " + vehicle.getMake());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Year: " + vehicle.getYear());
        System.out.println("Fuel Type: " + vehicle.getFuel());

        // Calculate and display some information
        System.out.println("Distance Traveled: " + vehicle.distanceTravelled() + " kms");
        System.out.println("Max Speed: " + vehicle.maxSpeed() + " kmph");
        System.out.println("Fuel Efficiency: " + vehicle.calculateFuelEfficiency() + " kml");
        System.out.println("-----------------------------------------");
    }
}
