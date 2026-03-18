import java.util.ArrayList;
import java.util.Scanner;

// This class represents a single student
class Student {
    private int id;
    private String name;
    private double marks;

    // Constructor to create a student object
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Method to get student ID
    public int getId() {
        return id;
    }

    // Method to display student details
    public void display() {
        System.out.println("ID: " + id + " Name: " + name + " Marks: " + marks);
    }
}

public class StudentManagementSystem {

    // This method safely takes integer input from user
    public static int getIntInput(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // clear wrong input
            }
        }
    }

    // This method safely takes double input (for marks)
    public static double getDoubleInput(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next(); // clear wrong input
            }
        }
    }

    public static void main(String[] args) {

        // ArrayList to store multiple students
        ArrayList<Student> students = new ArrayList<>();

        // Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // Loop will run until user chooses to exit
        while (true) {

            // Display menu options
            System.out.println();
            System.out.println("Student Management System");
            System.out.println("1 Add Student");
            System.out.println("2 View Students");
            System.out.println("3 Search Student");
            System.out.println("4 Delete Student");
            System.out.println("5 Exit");

            // Take user choice safely
            int choice = getIntInput(sc, "Enter your choice: ");

            // Option 1 Add Student
            if (choice == 1) {

                // Take student ID
                int id = getIntInput(sc, "Enter ID: ");
                sc.nextLine(); // clear buffer

                // Take student name
                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                // Take student marks
                double marks = getDoubleInput(sc, "Enter Marks: ");

                // Add new student to list
                students.add(new Student(id, name, marks));

                System.out.println("Student added successfully");

            }

            // Option 2 View all students
            else if (choice == 2) {

                // Check if list is empty
                if (students.isEmpty()) {
                    System.out.println("No students found");
                } else {
                    // Loop through all students and display them
                    for (Student s : students) {
                        s.display();
                    }
                }
            }

            // Option 3 Search student by ID
            else if (choice == 3) {

                int searchId = getIntInput(sc, "Enter ID to search: ");
                boolean found = false;

                // Loop through list to find student
                for (Student s : students) {
                    if (s.getId() == searchId) {
                        s.display();
                        found = true;
                        break;
                    }
                }

                // If not found
                if (!found) {
                    System.out.println("Student not found");
                }
            }

            // Option 4 Delete student
            else if (choice == 4) {

                int deleteId = getIntInput(sc, "Enter ID to delete: ");

                // removeIf will delete matching student
                boolean removed = students.removeIf(s -> s.getId() == deleteId);

                if (removed) {
                    System.out.println("Student deleted successfully");
                } else {
                    System.out.println("Student not found");
                }
            }

            // Option 5 Exit program
            else if (choice == 5) {

                System.out.println("Program ended");
                sc.close();
                break;
            }

            // If user enters wrong menu option
            else {
                System.out.println("Invalid choice");
            }
        }
    }
}