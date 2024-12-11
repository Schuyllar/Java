package org.example;

import java.util.Scanner;

public class InchConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

// Ask the user to enter a value in inches
        System.out.print("Enter the value in inches: ");
        double inches = scanner.nextDouble();

// Call methods to convert inches to feet and yards
        convertInchesToFeet(inches);
        convertInchesToYards(inches);

        scanner.close();
    }

    // Method to convert inches to feet
    public static void convertInchesToFeet(double inches) {
        double feet = inches / 12; // There are 12 inches in a foot
        System.out.printf("%.2f inches is equal to %.2f feet.%n", inches, feet);
    }

    // Method to convert inches to yards
    public static void convertInchesToYards(double inches) {
        double yards = inches / 36; // There are 36 inches in a yard (3 feet x 12 inches)
        System.out.printf("%.2f inches is equal to %.2f yards.%n", inches, yards);
    }
}