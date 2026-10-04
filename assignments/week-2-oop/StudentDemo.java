class Student {
    private String name;
    private int rollNumber;
    private double marks;

    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public void displayDetails() {
        System.out.println("Student Roll No: " + rollNumber);
        System.out.println("Student Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("---------------------------");
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 101, 88.5);
        Student student2 = new Student("Bob", 102, 92.0);

        student1.displayDetails();
        student2.displayDetails();
    }
}