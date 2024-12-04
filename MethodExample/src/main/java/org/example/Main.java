package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter party one name: ");
        String partyOneName = scanner.nextLine();

        System.out.println("Enter party one percentage of votes: ");
        double partyOnePercentage = Double.parseDouble(scanner.nextLine());
    }

    public static void displayPartyVotePercentage(String partyName, double partyPercentageOfVotes) {
        System.out.printf("Party %s vote percentage: %.2f%%\n",partyName, partyPercentageOfVotes);
    }
}