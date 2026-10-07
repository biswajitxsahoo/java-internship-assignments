import java.util.ArrayList;
import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> marksList = new ArrayList<>();

        System.out.print("How many students? ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter marks for student " + (i + 1) + ": ");
            double marks = scanner.nextDouble();
            marksList.add(marks);
        }

        if (marksList.isEmpty()) {
            System.out.println("No marks entered.");
        } else {
            double highest = marksList.get(0);
            double lowest = marksList.get(0);
            double total = 0;

            for (double mark : marksList) {
                if (mark > highest) {
                    highest = mark;
                }
                if (mark < lowest) {
                    lowest = mark;
                }
                total += mark;
            }

            double average = total / marksList.size();

            System.out.println("\n--- Marks Summary ---");
            System.out.println("Highest Marks: " + highest);
            System.out.println("Lowest Marks: " + lowest);
            System.out.println("Average Marks: " + average);
        }

        scanner.close();
    }
}