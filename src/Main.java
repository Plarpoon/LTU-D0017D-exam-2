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
        // Talk with the users and get the input
        System.out.print("Enter today's date [mm-dd]" + "\n");
        try (Scanner input = new Scanner(System.in)) {
            String date = input.nextLine();
        }
        System.out.print("Enter time of sunrise [hh: mm]" + "\n");
        try (Scanner input = new Scanner(System.in)) {
            String sunrise = input.nextLine();
        }
        System.out.print("Enter time of sunset [hh: mm]" + "\n");
        try (Scanner input = new Scanner(System.in)) {
            String sunset = input.nextLine();
        }
    }
}