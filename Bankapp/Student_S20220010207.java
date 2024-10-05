import java.util.Scanner;

class Student {
    private int rollNumber;
    private String name;
    private char grade;
    private int yearOfStudy;
    private String branch;

    // Constructor
    Student() {
    }

    void setRoll(int roll) {
        this.rollNumber = roll;
    }

    void setName(String name) {
        this.name = name;
    }

    void setGrade(char grade) {
        this.grade = grade;
    }

    void setYearOfStudy(int yos) {
        this.yearOfStudy = yos;
    }

    void setBranch(String branch) {
        this.branch = branch;
    }

    int getRoll() {
        return this.rollNumber;
    }

    String getName() {
        return this.name;
    }

    char getGrade() {
        return this.grade;
    }

    int getYearOfStudy() {
        return this.yearOfStudy;
    }

    String getBranch() {
        return this.branch;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        System.out.println("Enter the details of the first student: (branch, grade, name, rollno, years of study)");
        s1.setBranch(scanner.nextLine());
        s1.setGrade(scanner.nextLine().charAt(0));
        s1.setName(scanner.nextLine());
        s1.setRoll(scanner.nextInt());
        s1.setYearOfStudy(scanner.nextInt());
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter the details of the second student: (branch, grade, name, rollno, years of study)");
        s2.setBranch(scanner.nextLine());
        s2.setGrade(scanner.nextLine().charAt(0));
        s2.setName(scanner.nextLine());
        s2.setRoll(scanner.nextInt());
        s2.setYearOfStudy(scanner.nextInt());
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter the details of the third student: (branch, grade, name, rollno, years of study)");
        s3.setBranch(scanner.nextLine());
        s3.setGrade(scanner.nextLine().charAt(0));
        s3.setName(scanner.nextLine());
        s3.setRoll(scanner.nextInt());
        s3.setYearOfStudy(scanner.nextInt());

        // Print student details
        System.out.println("Student 1:");
        System.out.println("Name: " + s1.getName());
        System.out.println("Branch: " + s1.getBranch());
        System.out.println("Grade: " + s1.getGrade());
        System.out.println("Roll Number: " + s1.getRoll());
        System.out.println("Year of Study: " + s1.getYearOfStudy());

        System.out.println("Student 2:");
        System.out.println("Name: " + s2.getName());
        System.out.println("Branch: " + s2.getBranch());
        System.out.println("Grade: " + s2.getGrade());
        System.out.println("Roll Number: " + s2.getRoll());
        System.out.println("Year of Study: " + s2.getYearOfStudy());

        System.out.println("Student 3:");
        System.out.println("Name: " + s3.getName());
        System.out.println("Branch: " + s3.getBranch());
        System.out.println("Grade: " + s3.getGrade());
        System.out.println("Roll Number: " + s3.getRoll());
        System.out.println("Year of Study: " + s3.getYearOfStudy());

        scanner.close();
    }
}
