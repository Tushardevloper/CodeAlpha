package CodeAlpha.Task_1;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        //Input the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        //ArrayList to store the average grades for each student
        ArrayList<Double> averageGrades = new ArrayList<>();

        //Input grades for each student and calculate their average
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter grades for Student " + (i + 1) + ":");
            double sum = 0;

            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.print("  Subject " + (j + 1) + ": ");
                int grade = scanner.nextInt();
                sum += grade;
            }

            double average = sum / numberOfSubjects;
            averageGrades.add(average);
            System.out.println("  Average grade for Student " + (i + 1) + ": " + average);
        }

        //overall average, highest, and lowest average grades
        double overallSum = 0;
        double highestAverage = averageGrades.get(0);
        double lowestAverage = averageGrades.get(0);

        for (double avg : averageGrades) {
            overallSum += avg;
            if (avg > highestAverage) {
                highestAverage = avg;
            }
            if (avg < lowestAverage) {
                lowestAverage = avg;
            }
        }

        double overallAverage = overallSum / numberOfStudents;

        //Display the results
        System.out.println("Overall average grade: " + overallAverage);
        System.out.println("Highest average grade: " + highestAverage);
        System.out.println("Lowest average grade: " + lowestAverage);

        scanner.close();
    }
}