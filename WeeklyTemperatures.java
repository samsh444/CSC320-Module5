package module5;

import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperatures {

    public static void main(String[] args) {

        // Create Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Store the days of the week in one ArrayList
        ArrayList<String> days = new ArrayList<String>();

        // Store matching temperatures in a second ArrayList
        ArrayList<Double> temperatures = new ArrayList<Double>();

        // Add days of the week to the ArrayList
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        // Add average temperatures that correspond to each day
        temperatures.add(72.5);
        temperatures.add(75.0);
        temperatures.add(78.3);
        temperatures.add(80.1);
        temperatures.add(77.6);
        temperatures.add(73.4);
        temperatures.add(71.9);

        // Prompt the user to enter a day or request the entire week
        System.out.print("Enter a day of the week or enter week: ");
        String userChoice = input.nextLine().toLowerCase();

        // Continue prompting until a valid entry is provided
        while (!isValidChoice(userChoice, days)) {
            System.out.print("Invalid entry. Enter Monday through Sunday or week: ");
            userChoice = input.nextLine().toLowerCase();
        }

        // Display all temperatures and weekly average if "week" is entered
        if (userChoice.equals("week")) {
            displayWeek(days, temperatures);

        // Otherwise display the temperature for the selected day
        } else {
            int dayIndex = findDayIndex(userChoice, days);
            displayOneDay(days, temperatures, dayIndex);
        }

        // Close Scanner when program is finished
        input.close();
    }

    // Check whether the user entered a valid day or the word "week"
    private static boolean isValidChoice(String choice, ArrayList<String> days) {

        if (choice.equals("week")) {
            return true;
        }

        // Search through the days ArrayList for a match
        for (String day : days) {
            if (choice.equals(day.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    // Find and return the index position of the selected day
    private static int findDayIndex(String choice, ArrayList<String> days) {

        for (int index = 0; index < days.size(); index++) {
            if (choice.equals(days.get(index).toLowerCase())) {
                return index;
            }
        }

        return -1;
    }

    // Display the temperature for one specific day
    private static void displayOneDay(ArrayList<String> days,
                                      ArrayList<Double> temperatures,
                                      int index) {

        System.out.println();
        System.out.println("Temperature for Selected Day");
        System.out.println("----------------------------");

        System.out.printf("%s: %.1f degrees%n",
                days.get(index),
                temperatures.get(index));
    }

    // Display temperatures for the entire week and calculate the average
    private static void displayWeek(ArrayList<String> days,
                                    ArrayList<Double> temperatures) {

        double total = 0;

        System.out.println();
        System.out.println("Weekly Temperature Summary");
        System.out.println("--------------------------");

        // Loop through both ArrayLists and display each day and temperature
        for (int index = 0; index < days.size(); index++) {

            System.out.printf("%s: %.1f degrees%n",
                    days.get(index),
                    temperatures.get(index));

            // Add each temperature to the running total
            total = total + temperatures.get(index);
        }

        // Calculate weekly average temperature
        double average = total / temperatures.size();

        System.out.println();

        // Display the weekly average
        System.out.printf("Weekly average temperature: %.1f degrees%n", average);
    }
}