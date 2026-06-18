import java.util.ArrayList;
import java.util.Scanner;

// Student Class
class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void display() {
        System.out.println("ID: " + id +
                " | Name: " + name +
                " | Marks: " + marks);
    }
}

public class StudentManagementSystem {

    // Method for integer input
    public static int getIntInput(Scanner sc, String message) {
        while (true) {
            System.out.print(message);

            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("Invalid input. Enter a number.");
                sc.next();
            }
        }
    }

    // Method for double input
    public static double getDoubleInput(Scanner sc, String message) {
        while (true) {
            System.out.print(message);

            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            } else {
                System.out.println("Invalid input. Enter valid marks.");
                sc.next();
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Marks");
            System.out.println("6. Exit");

            int choice = getIntInput(sc, "Enter your choice: ");

            switch (choice) {

                // Add Student
                case 1:
                    int id = getIntInput(sc, "Enter ID: ");
                    sc.nextLine();

                    boolean exists = false;

                    for (Student s : students) {
                        if (s.getId() == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Student ID already exists!");
                    } else {
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        double marks = getDoubleInput(sc, "Enter Marks: ");

                        students.add(new Student(id, name, marks));

                        System.out.println("Student added successfully!");
                    }
                    break;

                // View Students
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\nStudent Records:");
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                // Search Student
                case 3:
                    int searchId = getIntInput(sc, "Enter ID to search: ");

                    boolean found = false;

                    for (Student s : students) {
                        if (s.getId() == searchId) {
                            s.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                // Delete Student
                case 4:
                    int deleteId = getIntInput(sc, "Enter ID to delete: ");

                    boolean removed = students.removeIf(s -> s.getId() == deleteId);

                    if (removed) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                // Update Marks
                case 5:
                    int updateId = getIntInput(sc, "Enter ID: ");

                    boolean updated = false;

                    for (Student s : students) {
                        if (s.getId() == updateId) {
                            double newMarks = getDoubleInput(sc, "Enter New Marks: ");
                            s.setMarks(newMarks);

                            System.out.println("Marks updated successfully!");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Student not found.");
                    }
                    break;

                // Exit
                case 6:
                    System.out.println("Thank you for using the system.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}