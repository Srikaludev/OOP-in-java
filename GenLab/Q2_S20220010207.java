import java.util.Random;
enum PerformanceLevel {
    EXCELLENT, AVERAGE, POOR;
}
class Employee {
    private String name;
    private String address;
    private double salary;
    private String jobTitle;

    public Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double calculateBonus() {
        // Default implementation for bonus calculation (15% of salary)
        return 0.15 * salary;
    }

    public String generatePerformanceReport() {
        Random rand = new Random();
        int index = rand.nextInt(PerformanceLevel.values().length);
        PerformanceLevel level = PerformanceLevel.values()[index];

        switch (level) {
            case EXCELLENT:
                return "Performance report for " + getJobTitle() + ": Excellent";
            case AVERAGE:
                return "Performance report for " + getJobTitle() + ": Average";
            case POOR:
                return "Performance report for " + getJobTitle() + ": Poor";
        }

        return "No performance report available";
    }

    public void manageProjects() {
        System.out.println("Employee is not a project manager");
    }
}
class Manager extends Employee {
    public Manager(String name, String address, double salary, String jobTitle) {
        super(name, address, salary, jobTitle);
    }
    @Override
    public double calculateBonus() {
        return 0.15 * getSalary();
    }
    public void manageProjects() {
        System.out.println("Manager is managing projects");
    }
}
class Developer extends Employee {
    public Developer(String name, String address, double salary, String jobTitle) {
        super(name, address, salary, jobTitle);
    }
    public void manageProjects() {
        System.out.println("Developer is working on projects");
    }
}
class Programmer extends Employee {
    public Programmer(String name, String address, double salary, String jobTitle) {
        super(name, address, salary, jobTitle);
    }
    public void manageProjects() {
        System.out.println("Programmer is contributing to projects");
    }
}
public class Q2_S20220010207 {
    public static void main(String[] args) {
        Manager manager = new Manager("John Smith", "123 Main St", 80000.0, "Manager");
        Developer developer = new Developer("Alice Johnson", "456 Elm St", 60000.0, "Developer");
        Programmer programmer = new Programmer("Bob Williams", "789 Oak St", 50000.0, "Programmer");
        System.out.println("Manager Bonus: $" + manager.calculateBonus());
        System.out.println(manager.generatePerformanceReport());
        System.out.println("Developer Bonus: $" + developer.calculateBonus());
        System.out.println(developer.generatePerformanceReport());
        System.out.println("Programmer Bonus: $" + programmer.calculateBonus());
        System.out.println(programmer.generatePerformanceReport());
    }
}