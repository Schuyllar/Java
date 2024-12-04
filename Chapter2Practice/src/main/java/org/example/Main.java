package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // This is where I put input:
        System.out.print("Enter the number of minutes: ");
        int minutes = scanner.nextInt();

        // These are the calculations like in programming logic:
        int hours = minutes / 60;
        int days = hours / 24;

        // This is where the output comes out:
        System.out.println("Minutes: " + minutes);
        System.out.println("Hours: " + hours);
        System.out.println("Days: " + days);
    }
}