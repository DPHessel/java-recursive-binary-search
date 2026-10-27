/*
 * Deuane Hessel
 * CIST 2372 Java 2 - Lesson 9 Lab Project
 * File: J209_4.java
 *
 * Summary:
 * Searches the required descending array using a recursive binary search.
 * The program validates a user-selected target, displays each search step,
 * and reports the matching index or explains that the target was not found.
 * Lines beginning with //* identify assignment-specific modifications.
 */

// Scanner reads an entire line so invalid keyboard input can be handled safely.
import java.util.Scanner;

// The class contains the input method and the recursive searching algorithm.
public class J209_4 {

    // //* Stores the required values in descending rather than ascending order.
    private static final int[] NUMBERS = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    // Java starts the application by calling main.
    public static void main(String[] args) {

        // Creates one keyboard reader for the entire program.
        Scanner input = new Scanner(System.in);

        // Shows the search data so the user understands which values are available.
        System.out.println("Recursive Binary Search - Descending Array");
        System.out.print("Array: ");

        // Prints every value, keeping the original descending order visible.
        for (int index = 0; index < NUMBERS.length; index++) {
            System.out.print(NUMBERS[index]);

            // Avoids adding an extra comma after the final array element.
            if (index < NUMBERS.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        // //* Validates keyboard input before calling the recursive search.
        // Values outside 0-10 are permitted so the not-found case can be tested.
        int target = readInteger(input);

        // //* Prints the search boundaries and midpoint during each recursive call.
        System.out.println("\nSearch steps:");

        // The first call searches the entire array from index 0 to its last index.
        int result = recursiveBinarySearch(NUMBERS, target, 0, NUMBERS.length - 1, 1);

        // A nonnegative result is an actual array index containing the target.
        if (result >= 0) {
            System.out.println("\nValue " + target + " found at index " + result + ".");
        } else {
            // A return value of -1 means the search boundaries became empty.
            System.out.println("\nValue " + target + " was not found in the array.");
        }

        // Closes the reader because no further keyboard input is needed.
        input.close();
    }

    // //* Accepts any valid int, allowing successful and unsuccessful searches.
    private static int readInteger(Scanner input) {

        // Keeps asking until the response can be converted into an integer.
        while (true) {
            System.out.print("Enter a whole number to search for: ");

            // Reading text first avoids Scanner's invalid-token exception.
            String response = input.nextLine().trim();

            try {
                // Converts a complete whole-number response into an int.
                return Integer.parseInt(response);
            } catch (NumberFormatException exception) {
                // //* Gives feedback and re-prompts instead of ending the program.
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    // Recursively searches only the inclusive index range [left, right].
    // //* The step parameter makes recursion visible for debugging and explanation.
    private static int recursiveBinarySearch(int[] values, int target,
                                             int left, int right, int step) {

        // The base case stops recursion once no possible elements remain.
        if (left > right) {
            System.out.println("Step " + step + ": range is empty; stop searching.");
            return -1;
        }

        // Calculates the midpoint without adding left and right directly.
        // This form avoids possible integer overflow for very large arrays.
        int middle = left + (right - left) / 2;

        // //* Displays the active boundaries and midpoint for the debugger video.
        System.out.println("Step " + step + ": left=" + left
                + ", right=" + right + ", middle=" + middle
                + ", middle value=" + values[middle]);

        // Finding the target at the midpoint completes the search immediately.
        if (values[middle] == target) {
            return middle;
        }

        // //* DESCENDING-ORDER MODIFICATION:
        // Values larger than the midpoint appear on the LEFT side of this array.
        if (target > values[middle]) {
            // The next call discards the midpoint and all smaller right-side values.
            return recursiveBinarySearch(values, target, left, middle - 1, step + 1);
        }

        // Smaller values appear on the RIGHT side in a descending array.
        // The next call discards the midpoint and all larger left-side values.
        return recursiveBinarySearch(values, target, middle + 1, right, step + 1);
    }
}

/*
 * Documentation - Step-by-Step Algorithm:
 * 1. Display the descending array: {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}.
 * 2. Ask the user for an integer, repeating the prompt if input is invalid.
 * 3. Start the recursive search with left=0 and right=10.
 * 4. If left > right, return -1 because the search interval is empty.
 * 5. Calculate middle = left + (right - left) / 2.
 * 6. If values[middle] equals the target, return middle.
 * 7. If target is greater than values[middle], search the LEFT half.
 * 8. Otherwise, search the RIGHT half.
 * 9. Each recursive call shrinks the interval until a match or the base case.
 * 10. Display the resulting index or a not-found message.
 *
 * Modifications: Descending-order comparisons, validated user input,
 * step-by-step trace output, safe midpoint calculation, and explicit
 * not-found handling. No built-in binarySearch() method is used.
 *
 * Debugging demonstration (IntelliJ IDEA):
 * - Set a breakpoint at the midpoint calculation inside recursiveBinarySearch.
 * - Run in Debug mode and enter 8; inspect left, right, middle, and target.
 * - Use Step Into to follow recursive calls and watch the range shrink.
 * - Repeat with 11 to demonstrate the base case and -1 result.
 *
 * Source: Y. Daniel Liang, Introduction to Java Programming and Data
 * Structures, 13th Edition, Pearson, Chapter 18 (Recursion).
 */
