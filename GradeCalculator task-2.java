import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Grade Calculator!");
        
        // Constants
        int numSubjects;
        final int MAX_MARKS_PER_SUBJECT = 100;
        
        // Input number of subjects
        System.out.print("Enter number of subjects: ");
        numSubjects = scanner.nextInt();
        
        // Array to store marks of each subject
        int[] marks = new int[numSubjects];
        
        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i+1) + ": ");
            marks[i] = scanner.nextInt();
            
            // Validate marks to be within range
            if (marks[i] < 0 || marks[i] > MAX_MARKS_PER_SUBJECT) {
                System.out.println("Invalid marks entered. Marks should be between 0 and " + MAX_MARKS_PER_SUBJECT);
                return;
            }
        }
        
        // Calculate total marks
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        
        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;
        
        // Grade Calculation based on average percentage
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F'; // Fail
        }
        
        // Display Results
        System.out.println("\n----- Results -----");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}

