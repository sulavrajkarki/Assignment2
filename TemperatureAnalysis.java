// Name: Sulav Raj Karki
// Student ID: 100959480
// Date: 10/9/2024
// File: Assignment 2



import java.util.Scanner;

public class TemperatureAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of days to analyze
        int numberOfDays;
        do {
            System.out.print("Enter the number of days to analyze (between 2 and 366): ");
            numberOfDays = scanner.nextInt();
            if (numberOfDays < 2 || numberOfDays > 366) {
                System.out.println("Invalid number of days. Please enter a value between 2 and 366.");
            }
        } while (numberOfDays < 2 || numberOfDays > 366);

        // Arrays to store the low and high temperatures
        double[] lowTemps = new double[numberOfDays];
        double[] highTemps = new double[numberOfDays];

        // Input: Temperatures for each day
        for (int i = 0; i < numberOfDays; i++) {
            System.out.println("Day " + (i + 1) + ":");

            // Low temperature
            do {
                System.out.print("Enter the low temperature (between -100 and 100): ");
                lowTemps[i] = scanner.nextDouble();
                if (lowTemps[i] < -100 || lowTemps[i] > 100) {
                    System.out.println("Invalid low temperature. Please enter a value between -100 and 100.");
                }
            } while (lowTemps[i] < -100 || lowTemps[i] > 100);

            // High temperature
            do {
                System.out.print("Enter the high temperature (between -100 and 100): ");
                highTemps[i] = scanner.nextDouble();
                if (highTemps[i] < lowTemps[i] || highTemps[i] > 100) {
                    System.out.println("Invalid high temperature. It should be between the low temperature and 100.");
                }
            } while (highTemps[i] < lowTemps[i] || highTemps[i] > 100);
        }

        // Display temperatures and compute statistics
        double overallLow = lowTemps[0];
        double overallHigh = highTemps[0];
        double sumOfAverages = 0;

        for (int i = 0; i < numberOfDays; i++) {
            double dailyAverage = (lowTemps[i] + highTemps[i]) / 2;
            sumOfAverages += dailyAverage;

            // Track overall highest and lowest temperatures
            if (lowTemps[i] < overallLow) {
                overallLow = lowTemps[i];
            }
            if (highTemps[i] > overallHigh) {
                overallHigh = highTemps[i];
            }

            System.out.println("Day " + (i + 1) + " - Low: " + lowTemps[i] + ", High: " + highTemps[i] + ", Average: " + dailyAverage);
        }

        // Display overall statistics
        double overallAverage = sumOfAverages / numberOfDays;
        System.out.println("Overall Average Temperature: " + overallAverage);
        System.out.println("Lowest Temperature Recorded: " + overallLow);
        System.out.println("Highest Temperature Recorded: " + overallHigh);

        scanner.close();
    }
}
