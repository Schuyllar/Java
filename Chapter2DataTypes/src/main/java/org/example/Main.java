package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World");
        System.out.println("Hello Again");

        // taking input
        // 1. Create a Scanner object
        Scanner scanner = new Scanner(System.in);
        // 2. Name the beginning part the same as the object after "Scanner"
        scanner.nextLine();

        String nameInput = scanner.nextLine();

        System.out.println("You entered: " + nameInput);

        short birthYear = Short.parseShort(scanner.nextLine());

        System.out.println("Enter your birth year: " + birthYear);
    }
}