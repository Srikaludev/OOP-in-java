import java.util.Random;

// Define enums for make and color
enum Make {
    Tata, Ford, BMW, Rolls_Royce, Benz, Leyland, Isuzu
}

enum Color {
    Blue, Black, White, Grey, Silver
}

// Main Vehicle class
class Vehicle {
    private Make make;
    private Color color;
    private int year;
    private int fuel;
    private double enginePower; // Corrected variable name
    private double weight;     // Corrected variable name
    private String fuelType;   // Corrected variable name

    public Vehicle(Make make, Color color, int year, int fuel, double enginePower, double weight, String fuelType) {
        // Check if the provided values are valid
        if (year < 2010 || year > 2021) {
            throw new IllegalArgumentException("Invalid year. Year should be between 2010 and 2021.");
        }
        if (fuel < 1 || fuel > 3) {
            throw new IllegalArgumentException("Invalid fuel type. Use 1 for diesel, 2 for petrol, or 3");
        }
    
        this.make = make;
        this.color = color;
        this.year = year;
        this.fuel = fuel;
        this.enginePower = enginePower;
        this.weight = weight;
        this.fuelType = fuelType;
    }

    public boolean isClimbUpHill() {
        if (enginePower > 150 && weight < 2000) {
            return true;
        } else {
            return false;
        }
    }

    public double getAcceleration(double time) {
        // Acceleration a = dv/dt = 8 - 2t
        double acceleration = 8 - 2 * time;
        return acceleration;
    }

    // Getter methods for enginePower, weight, and fuelType
    public double getEnginePower() {
        return enginePower;
    }

    public double getWeight() {
        return weight;
    }

    public String getFuelType() {
        return fuelType;
    }

    public static class VehicleData {
        double enginePower;
        double weight;
        String fuelType;

        public VehicleData() {
            Random rand = new Random();
            this.enginePower = 100 + rand.nextDouble() * 400;
            this.weight = 1000 + rand.nextDouble() * 9000;
            this.fuelType = (rand.nextBoolean()) ? "Gasoline" : "Diesel";
        }

        public double getEnginePower() {
            return enginePower;
        }

        public double getWeight() {
            return weight;
        }

        public String getFuelType() {
            return fuelType;
        }
    }

    public static Vehicle[] generateVehicles(int n) {
        if (n < 5 || n > 20) {
            throw new IllegalArgumentException("n should be in the range [5, 20]");
        }

        Vehicle[] vehicles = new Vehicle[n];
        for (int i = 0; i < n; i++) {
            VehicleData vehicleData = new VehicleData();
            vehicles[i] = new Vehicle(Make.Tata, Color.Blue, 2020, 1,
                    vehicleData.getEnginePower(), vehicleData.getWeight(), vehicleData.getFuelType());
        }

        return vehicles;
    }

    public static void main(String[] args) {
        // Example usage:
        Vehicle myVehicle = new Vehicle(Make.Tata, Color.Blue, 2020, 1, 250, 2800, "Gasoline");
        boolean canClimbHill = myVehicle.isClimbUpHill();
        System.out.println("Can the vehicle climb up a hill? " + canClimbHill);

        double time = 5; // Example time in seconds
        double acceleration = myVehicle.getAcceleration(time);
        System.out.println("Acceleration at t = " + time + " seconds: " + acceleration);

        int n = 10; // Example: generate an array of 10 random vehicles
        Vehicle[] randomVehicles = generateVehicles(n);

        // Print the generated vehicles
        for (Vehicle vehicle : randomVehicles) {
            System.out.println("Engine Power: " + vehicle.getEnginePower() +
                    " Weight: " + vehicle.getWeight() +
                    " Fuel Type: " + vehicle.getFuelType());
        }
    }
}

class VehicleManager {
    // Member Inner class Truck
    public class Truck {
        private int doors;
        private int seatingCapacity;
        private double loadCapacity;
        private int numberOfTyres;

        // Constructor for Truck
        public Truck() {
            doors = 2;
            seatingCapacity = 2;
            loadCapacity = 12.0;
            numberOfTyres = 6; // Assuming 6 tyres as a standard truck has more than 4 tyres
        }

        // Getter methods (optional)
        public int getDoors() {
            return doors;
        }

        public int getSeatingCapacity() {
            return seatingCapacity;
        }

        public double getLoadCapacity() {
            return loadCapacity;
        }

        public int getNumberOfTyres() {
            return numberOfTyres;
        }

        // Method to print Truck details (called from within the class)
        public void printDetails() {
            System.out.println("Truck Details:");
            System.out.println("Doors: " + doors);
            System.out.println("Seating Capacity: " + seatingCapacity);
            System.out.println("Load Capacity: " + loadCapacity + " tons");
            System.out.println("Number of Tyres: " + numberOfTyres);
        }

        // Local inner class Speed to calculate velocity and acceleration
        public void getOdometry(double time) {
            class Speed {
                double calculateVelocity() {
                    // Implement velocity calculation logic (example calculation)
                    double velocity = loadCapacity * 5; // Example calculation
                    return velocity;
                }

                double calculateAcceleration() {
                    // Implement acceleration calculation logic (example calculation)
                    double acceleration = loadCapacity * 2; // Example calculation
                    return acceleration;
                }

                void printSpeedInfo() {
                    double velocity = calculateVelocity();
                    double acceleration = calculateAcceleration();
                    System.out.println("Velocity: " + velocity + " km/h");
                    System.out.println("Acceleration: " + acceleration + " m/s^2");
                }
            }

            Speed speed = new Speed();
            speed.printSpeedInfo();
        }
    }

    // Method to generate an array of k Trucks (called from the scope of outer class)
    public Truck[] generateTrucks(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("k should be greater than 0");
        }

        Truck[] trucks = new Truck[k];
        for (int i = 0; i < k; i++) {
            trucks[i] = new Truck();
        }

        return trucks;
    }

    public static void main(String[] args) {
        VehicleManager manager = new VehicleManager();
        int k = 5; // Example: generate an array of 5 trucks

        // Generate and print trucks
        Truck[] trucks = manager.generateTrucks(k);
        for (Truck truck : trucks) {
            truck.printDetails();
            truck.getOdometry(10.0); // Example time for calculating velocity and acceleration
        }
    }
}
