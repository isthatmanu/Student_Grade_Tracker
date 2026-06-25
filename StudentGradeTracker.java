// Import ArrayList class to store multiple student records
import java.util.ArrayList;

// Import Scanner class to take user input
import java.util.Scanner;

// Student class stores student details
class Student {

    // Student attributes
    int id;
    String name;
    int marks;

    // Constructor to initialize student data
    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Method to calculate grade based on marks
    String getGrade() {

        if (marks >= 90)
            return "A";
        else if (marks >= 75)
            return "B";
        else if (marks >= 60)
            return "C";
        else
            return "D";
    }
}

// Main class
public class StudentGradeTracker {

    // Main method - program starts here
    public static void main(String[] args) {

        // Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // ArrayList to store student objects
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        // Loop runs until user chooses Exit
        do {

            // Display menu
            System.out.println("\n=================================");
            System.out.println("      STUDENT GRADE TRACKER");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            // Read menu choice
            choice = sc.nextInt();

            // Perform action based on user choice
            switch (choice) {

                // Add Student
                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    // Clear buffer
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    // Create student object and add to list
                    students.add(new Student(id, name, marks));

                    System.out.println("Student Added Successfully!");
                    break;

                // View Students
                case 2:

                    // Check if list is empty
                    if (students.isEmpty()) {
                        System.out.println("No Student Records Found.");
                    } else {

                        System.out.println("\n----- STUDENT LIST -----");

                        // Display all students
                        for (Student s : students) {

                            System.out.println(
                                    "ID: " + s.id +
                                    " | Name: " + s.name +
                                    " | Marks: " + s.marks +
                                    " | Grade: " + s.getGrade());
                        }
                    }

                    break;

                // Search Student
                case 3:

                    // Clear buffer
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String searchName = sc.nextLine();

                    boolean found = false;

                    // Search student by name
                    for (Student s : students) {

                        if (s.name.equalsIgnoreCase(searchName)) {

                            System.out.println("\nStudent Found");
                            System.out.println("ID: " + s.id);
                            System.out.println("Name: " + s.name);
                            System.out.println("Marks: " + s.marks);
                            System.out.println("Grade: " + s.getGrade());

                            found = true;
                            break;
                        }
                    }

                    // If student not found
                    if (!found) {
                        System.out.println("Student Not Found.");
                    }

                    break;

                // Generate Report
                case 4:

                    if (students.isEmpty()) {

                        System.out.println("No Data Available.");
                    } else {

                        // Variable for total marks
                        int total = 0;

                        // Initialize highest and lowest marks
                        int highest = students.get(0).marks;
                        int lowest = students.get(0).marks;

                        // Assume first student is topper
                        String topper = students.get(0).name;

                        // Calculate statistics
                        for (Student s : students) {

                            total += s.marks;

                            if (s.marks > highest) {

                                highest = s.marks;
                                topper = s.name;
                            }

                            if (s.marks < lowest) {

                                lowest = s.marks;
                            }
                        }

                        // Calculate average marks
                        double average =
                                (double) total / students.size();

                        // Display report
                        System.out.println("\n==============================");
                        System.out.println("      STUDENT REPORT");
                        System.out.println("==============================");

                        for (Student s : students) {

                            System.out.println(
                                    "ID: " + s.id +
                                    " | Name: " + s.name +
                                    " | Marks: " + s.marks +
                                    " | Grade: " + s.getGrade());
                        }

                        System.out.println("\nTotal Students : "
                                + students.size());

                        System.out.println("Average Marks  : "
                                + average);

                        System.out.println("Highest Marks  : "
                                + highest);

                        System.out.println("Lowest Marks   : "
                                + lowest);

                        System.out.println("Topper         : "
                                + topper);
                    }

                    break;

                // Exit Program
                case 5:

                    System.out.println("Thank You!");
                    break;

                // Invalid menu choice
                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        // Close scanner to free resources
        sc.close();
    }
}