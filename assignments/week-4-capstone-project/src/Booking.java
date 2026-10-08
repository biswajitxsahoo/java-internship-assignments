public class Booking {
    private int bookingId;
    private String guestName;
    private String roomType; // Standard, Deluxe, Suite
    private int nights;
    private double pricePerNight;
    private double totalCost;

    public Booking(int bookingId, String guestName, String roomType, int nights, double pricePerNight) {
        this.bookingId = bookingId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
        this.pricePerNight = pricePerNight;
        this.totalCost = nights * pricePerNight;
    }

    public int getBookingId() { return bookingId; }
    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
    public int getNights() { return nights; }
    public double getPricePerNight() { return pricePerNight; }
    public double getTotalCost() { return totalCost; }

    public String toFileString() {
        return bookingId + "," + guestName + "," + roomType + "," + nights + "," + pricePerNight;
    }

    public void display() {
        System.out.println("ID: " + bookingId + " | Guest: " + guestName + " | Room: " + roomType + 
                           " | Nights: " + nights + " | Total Cost: ₹" + totalCost);
    }
}