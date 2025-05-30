import java.util.*;

class Student {
    private String id;
    private String name;
    private int age;
    private double grade;

    public Student(String id, String name, int age, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void display() {
        System.out.println("Student ID   : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Age          : " + age);
        System.out.println("Grade        : " + grade);
        System.out.println("-----------------------------");
    }

    public String getId() {
        return id;
    }
}

public class StudentRecordManagementSystem {
    private static Scanner sc = new Scanner(System.in);
    private static Map<String, Student> studentMap = new HashMap<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n*** Student Record Management System ***");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        if (studentMap.containsKey(id)) {
            System.out.println("Student already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Grade: ");
        double grade = sc.nextDouble();
        sc.nextLine(); // Clear buffer

        Student student = new Student(id, name, age, grade);
        studentMap.put(id, student);
        System.out.println("Student added successfully.");
    }

    private static void displayStudent() {
        System.out.print("Enter Student ID to display: ");
        String id = sc.nextLine();
        Student student = studentMap.get(id);
        if (student != null) {
            student.display();
        } else {
            System.out.println("Student not found!");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();
        if (studentMap.remove(id) != null) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student student : studentMap.values()) {
                student.display();
            }
        }
    }
}
