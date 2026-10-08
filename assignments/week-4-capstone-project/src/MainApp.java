import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelManager manager = new HotelManager();
        int choice = 0;

        while (choice != 4) {
            System.out.println("\n--- Hotel Booking Management System ---");
            System.out.println("1. Add New Booking");
            System.out.println("2. View All Bookings");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    System.out.print("Enter Guest Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Select Room Type:");
                    System.out.println("1. Standard (₹1500/night)");
                    System.out.println("2. Deluxe (₹3000/night)");
                    System.out.println("3. Suite (₹5000/night)");
                    System.out.print("Choice: ");
                    int roomChoice = Integer.parseInt(scanner.nextLine());

                    String roomType = "Standard";
                    double price = 1500.0;

                    if (roomChoice == 2) {
                        roomType = "Deluxe";
                        price = 3000.0;
                    } else if (roomChoice == 3) {
                        roomType = "Suite";
                        price = 5000.0;
                    }

                    System.out.print("Enter Number of Nights: ");
                    int nights = Integer.parseInt(scanner.nextLine());

                    manager.addBooking(name, roomType, nights, price);

                } else if (choice == 2) {
                    List<Booking> bookings = manager.getAllBookings();
                    if (bookings.isEmpty()) {
                        System.out.println("No active bookings found.");
                    } else {
                        System.out.println("\n--- Current Bookings ---");
                        for (Booking b : bookings) {
                            b.display();
                        }
                    }

                } else if (choice == 3) {
                    System.out.print("Enter Booking ID to cancel: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    manager.cancelBooking(id);

                } else if (choice == 4) {
                    System.out.println("Thank you for using Hotel Management System!");
                } else {
                    System.out.println("Invalid choice. Select 1-4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }

        scanner.close();
    }
}