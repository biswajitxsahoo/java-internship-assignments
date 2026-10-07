import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toFileString() {
        return id + "," + name + "," + department + "," + salary;
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Dept: " + department + " | Salary: $" + salary);
    }
}

public class EmployeeManagement {
    private static final String FILE_NAME = "employees.txt";
    private static ArrayList<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        loadFromFile();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Save Data to File");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = scanner.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = Double.parseDouble(scanner.nextLine());

                    employeeList.add(new Employee(id, name, dept, salary));
                    System.out.println("Employee added locally!");

                } else if (choice == 2) {
                    if (employeeList.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        System.out.println("\n--- Employee List ---");
                        for (Employee emp : employeeList) {
                            emp.display();
                        }
                    }
                } else if (choice == 3) {
                    saveToFile();
                } else if (choice == 4) {
                    saveToFile(); // Auto-save on exit
                    System.out.println("Goodbye!");
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numeric values where required.");
            }
        }

        scanner.close();
    }

    private static void saveToFile() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (Employee emp : employeeList) {
                writer.write(emp.toFileString() + "\n");
            }
            System.out.println("Employee records saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Failed to save records: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String dept = parts[2];
                    double salary = Double.parseDouble(parts[3]);
                    employeeList.add(new Employee(id, name, dept, salary));
                }
            }
            System.out.println("Loaded existing employee records from file.");
        } catch (IOException e) {
            System.out.println("No previous records found. Starting fresh.");
        }
    }
}