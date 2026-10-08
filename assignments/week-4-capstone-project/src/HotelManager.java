import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HotelManager {
    private static final String FILE_NAME = "bookings.txt";
    private List<Booking> bookings = new ArrayList<>();
    private int nextBookingId = 101;

    public HotelManager() {
        loadFromFile();
    }

    // Add new booking and calculate total cost automatically
    public void addBooking(String guestName, String roomType, int nights, double pricePerNight) {
        Booking booking = new Booking(nextBookingId++, guestName, roomType, nights, pricePerNight);
        bookings.add(booking);
        saveToFile();
        System.out.println("\nBooking successful! Total Cost: ₹" + booking.getTotalCost());
    }

    // View all current bookings
    public List<Booking> getAllBookings() {
        return bookings;
    }

    // Cancel a booking by ID
    public boolean cancelBooking(int bookingId) {
        boolean removed = bookings.removeIf(b -> b.getBookingId() == bookingId);
        if (removed) {
            saveToFile();
            System.out.println("Booking #" + bookingId + " cancelled successfully.");
            return true;
        } else {
            System.out.println("Booking #" + bookingId + " not found.");
            return false;
        }
    }

    // Save bookings array to text file
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Booking b : bookings) {
                writer.write(b.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving booking data: " + e.getMessage());
        }
    }

    // Load existing bookings on startup
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    String guestName = parts[1];
                    String roomType = parts[2];
                    int nights = Integer.parseInt(parts[3]);
                    double pricePerNight = Double.parseDouble(parts[4]);

                    bookings.add(new Booking(id, guestName, roomType, nights, pricePerNight));
                    if (id >= nextBookingId) {
                        nextBookingId = id + 1;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading existing bookings: " + e.getMessage());
        }
    }
}