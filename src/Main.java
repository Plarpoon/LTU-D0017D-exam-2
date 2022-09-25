
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

        boolean validDate = false;

        do {
            getDate(userInput, validDate); // Call the getDate method
        } while (validDate == false);

        getSunAmount(userInput); // Call the method to get the sun amount

        userInput.close(); // Close the scanner
    }

    private static void getDate(Scanner userInput, boolean validDate) {
        userInput.useDelimiter("-|\\s+"); // Use the delimiter to split the input

        System.out.print("Enter today's date [mm-dd]" + "\n");
        int month = userInput.nextInt(); // Get the month
        int day = userInput.nextInt(); // Read user input
        userInput.nextLine(); // Clear the buffer

        if (month == 06 || month == 07)
            validDate = true; // If the month is June or July, the date is valid
        else
            System.out.println("Invalid month, it's neither June or July.");
        // If the month is not June or July, the date is invalid

        System.out.println("Month: " + month + " Day: " + day);
    }

    private static double getSunAmount(Scanner userInput) {
        userInput.useDelimiter(":|\\s+"); // use space or colon as delimiter

        System.out.println("Enter time of sunrise [hh:mm]");
        int sunriseHour = userInput.nextInt(); // read hour
        int sunriseMinute = userInput.nextInt(); // read minute
        userInput.nextLine(); // consume newline

        System.out.println("Enter time of sunset [hh:mm]");
        int sunsetHour = userInput.nextInt(); // read hour
        int sunsetMinute = userInput.nextInt(); // read minute
        userInput.nextLine(); // consume newline

        // calculate the amount of sun time
        double sunHours = (sunsetHour - sunriseHour) + ((sunsetMinute - sunriseMinute) / 60.0);

        if (sunHours <= 0) {
            System.out.println("Sunset must be after sunrise"); // error message
            System.exit(0); // exit loop
        }

        System.out.println("Sun is up for " + sunHours + " hours"); // print the amount of sun time

        return sunHours; // return the amount of sun time
    }
}
