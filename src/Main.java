
/**
 * ===============================================================
 * What does the program do:
 * The program calculates how much money a stripe of solar cells
 * will produce in a very specific city in Sweden at a given period.
 * ===============================================================
 * Pseudocode steps:
 * Main:
 * 1. Initialize some support local variables to zero.
 * 2. Define the final variables given in the assignment.
 * 3. Create a do-while loop that will run until the user enters
 *    the correct values.
 * 4. Recover the values from the two get methods into the local variables.
 * 5. Calculate the total amount of money the solar cells will produce.
 * 6. Print the result.
 * 
 * Get Date:
 * 1. Read user input using the delimiter given in the assignment.
 * 2. Check if the input is valid.
 * 3. If the input is valid, return the input in a date array.
 * 4. If the input is not valid, exit the program.
 * 
 * Get Sun Amount:
 * 1. Read user input using the delimiter given in the assignment.
 * 2. Calculate the total amount of sun hours.
 * 3. Check if the time of sunrise is before the time of sunset.
 * 4. If the time of sunrise is before the time of sunset, return the
 *   total amount of sun hours.
 * 5. If the time of sunrise is after the time of sunset, exit the program.
 * 6. Return the total amount of sun hours.
 * ===============================================================
 * Alessandro Suha
 * alesuh-1
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in); // Create a Scanner object

        int day = 0;
        int month = 0;
        double sunHours = 0;
        int validDate = 0;
        int[] date = { 0, 0, 0 }; // Array to store the date

        final double solarRadiation = 166; // Solar radiation in kWh/m2
        final double solarPanelEfficiency = 0.2; // Solar panel efficiency
        final double electricityPrice = 0.9; // Electricity price in SEK/kWh
        final int nPanels = 26; // Number of solar panels
        final double areaPanels = 1.7 * 1; // Area of each solar panel in m2

        double totalAreaPanels = nPanels * areaPanels; // Calculate the total area of the solar panels.

        do {
            getDate(userInput, month, day, validDate, date); // Get the date from the user
        } while (date[2] == 0); // Repeat until the user enters a valid date

        month = date[0];
        day = date[1];

        sunHours = getSunAmount(userInput, sunHours); // Get the sun amount from the user

        // Calculate the production of the solar panel
        double totalProduction = (solarRadiation * sunHours * totalAreaPanels * solarPanelEfficiency) / 1000;

        // Calculate the price of electricity
        double totalCost = totalProduction * electricityPrice;

        System.out.printf("The production on %d/%d is: %.2f kWh to a value of: SEK %.2f\n", day, month,
                totalProduction,
                totalCost);

        userInput.close();
    }

    private static int[] getDate(Scanner userInput, int month, int day, int validDate, int[] date) {
        userInput.useDelimiter("-|\\s+"); // Use the delimiter to split the input

        System.out.print("Enter today's date [mm-dd]" + "\n");
        month = userInput.nextInt();
        day = userInput.nextInt();
        userInput.nextLine();

        if ((month == 06) && (day <= 30) && (day >= 1)) { // Check if the date is valid
            validDate = 1;
        } else if ((month == 07) && (day <= 31) && (day >= 1)) { // Check if the date is valid
            validDate = 1;
        } else {
            System.out.println("Invalid date, be sure it's a valid day of either June or July.");
            System.exit(1);
        }

        date[0] = month;
        date[1] = day;
        date[2] = validDate;

        return date;
    }

    private static double getSunAmount(Scanner userInput, double sunHours) { // Method to get the sun amount
        userInput.useDelimiter(":|\\s+"); // use space or colon as delimiter

        System.out.println("Enter time of sunrise [hh:mm]");
        int sunriseHour = userInput.nextInt();
        int sunriseMinute = userInput.nextInt();
        userInput.nextLine();

        System.out.println("Enter time of sunset [hh:mm]");
        int sunsetHour = userInput.nextInt();
        int sunsetMinute = userInput.nextInt();
        userInput.nextLine();

        // calculate the amount of sun time
        sunHours = (sunsetHour - sunriseHour) + ((sunsetMinute - sunriseMinute) / 60.0);

        if (sunHours <= 0) { // if sunHours is negative, add 24 hours
            System.out.println("Sunset must be after sunrise"); // error message
            System.exit(0); // exit loop
        }

        System.out.printf("Sun hours %.2f hours\n", sunHours); // print the amount of sun time

        return sunHours;
    }
}