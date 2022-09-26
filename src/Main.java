
/**
 * ===============================================================
 * YYYY
 * YYYY
 * YYYY
 * ===============================================================
 * Pseudocode steps:
 * 1. XXXX
 * 2. XXXX
 * 3. XXXX
 * ===============================================================
 * Alessandro Suha
 * alesuh-1
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in); // Create a Scanner object

        boolean validDate = false; // Flag to check if the date is valid
        int day = 0;
        int month = 0;
        double sunHours = 0;

        final double solarRadiation = 166 / 1000; // Solar radiation in W/m^2
        final double efficiency = 0.20 * solarRadiation; // Efficiency of the solar panel in W/m^2
        final double surface = 1.7 * 26; // Surface of the solar panel in m^2

        do {
            validDate = getDate(userInput, month, month, validDate); // Get the date from the user
        } while (validDate == false);

        getSunAmount(userInput, surface); // Call the method to get the sun amount

        // Calculate the production of the solar panel
        double production = solarRadiation * efficiency * surface * sunHours;
        System.out.println("The production on " + day + "/" + month + " is: " + production + " kWh");
        // TODO: SEK for KwH

        userInput.close();
    }

    private static boolean getDate(Scanner userInput, int month, int day, boolean validDate) { // Method to get the date
        userInput.useDelimiter("-|\\s+"); // Use the delimiter to split the input

        System.out.print("Enter today's date [mm-dd]" + "\n");
        month = userInput.nextInt();
        day = userInput.nextInt();
        userInput.nextLine();

        if (month == 06 || month == 07) {
            validDate = true; // If the month is June or July, the date is valid
        } else {
            System.out.println("Invalid month, it's neither June nor July.");
            // If the month is not June or July, the date is invalid
        }
        return validDate;
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

        System.out.println("Sun hours " + sunHours + " hours"); // print the amount of sun time

        return sunHours; // return the amount of sun time
    }
}