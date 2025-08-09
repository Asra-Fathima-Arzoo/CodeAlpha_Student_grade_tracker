import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Double> studentGrades = new ArrayList<>();

        System.out.println("--- Student Grade Tracker ---");
        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Student and Grade");
            System.out.println("2. Show Summary Report");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student grade: ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    studentNames.add(name);
                    studentGrades.add(grade);
                    System.out.println("Student and grade added.");
                    break;
                case 2:
                    showSummary(studentNames, studentGrades);
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting Student Grade Tracker. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void showSummary(ArrayList<String> names, ArrayList<Double> grades) {
        if (names.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }
        double sum = 0;
        double highest = grades.get(0);
        double lowest = grades.get(0);
        int highestIndex = 0;
        int lowestIndex = 0;
        for (int i = 0; i < grades.size(); i++) {
            double grade = grades.get(i);
            sum += grade;
            if (grade > highest) {
                highest = grade;
                highestIndex = i;
            }
            if (grade < lowest) {
                lowest = grade;
                lowestIndex = i;
            }
        }
        double average = sum / grades.size();
        System.out.println("\n--- Summary Report ---");
        System.out.printf("Average Score: %.2f\n", average);
        System.out.printf("Highest Score: %.2f (%s)\n", highest, names.get(highestIndex));
        System.out.printf("Lowest Score: %.2f (%s)\n", lowest, names.get(lowestIndex));
        System.out.println("\nAll Students:");
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%d. %s - %.2f\n", i + 1, names.get(i), grades.get(i));
        }
    }
} 