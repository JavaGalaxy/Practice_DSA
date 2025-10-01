// package arrays.twosumsorted;

/**
 * Test cases for TwoSumSorted
 */
public class TwoSumSortedTest {

    // ANSI color codes for terminal output
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String BLUE = "\u001B[34m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String PURPLE = "\u001B[35m";

    private static int testCount = 0;
    private static int passCount = 0;

    public static void main(String[] args) {
        TwoSumSorted solution = new TwoSumSorted();

        printHeader("Two Sum Sorted Array Tests");

        // Test case 1: Basic example from problem description
        testCase(solution, new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}, "Basic example");

        // Test case 2: Two elements at beginning
        testCase(solution, new int[]{2, 3, 4}, 6, new int[]{1, 3}, "Two elements at beginning and end");

        // Test case 3: Negative numbers
        testCase(solution, new int[]{-1, 0}, -1, new int[]{1, 2}, "Negative numbers");

        // Test case 4: Larger array
        testCase(solution, new int[]{1, 3, 4, 5, 7, 10, 11}, 9, new int[]{3, 4}, "Larger array middle elements");

        printSummary();
    }

    /**
     * Print colorful header
     */
    private static void printHeader(String title) {
        System.out.println(BOLD + BLUE + "═".repeat(60) + RESET);
        System.out.println(BOLD + BLUE + "  " + title + RESET);
        System.out.println(BOLD + BLUE + "═".repeat(60) + RESET);
        System.out.println();
    }

    /**
     * Print test summary
     */
    private static void printSummary() {
        System.out.println();
        System.out.println(BOLD + BLUE + "═".repeat(60) + RESET);
        System.out.println(BOLD + CYAN + "  Test Summary:" + RESET);
        System.out.println(BOLD + "  Total Tests: " + testCount + RESET);

        if (passCount == testCount) {
            System.out.println(BOLD + GREEN + "  ✓ All tests passed! (" + passCount + "/" + testCount + ")" + RESET);
        } else {
            System.out.println(BOLD + GREEN + "  ✓ Passed: " + passCount + RESET);
            System.out.println(BOLD + RED + "  ✗ Failed: " + (testCount - passCount) + RESET);
        }
        System.out.println(BOLD + BLUE + "═".repeat(60) + RESET);
    }

    /**
     * Enhanced test case method with colorful output
     */
    private static void testCase(TwoSumSorted solution, int[] numbers, int target, int[] expected, String description) {
        testCount++;

        System.out.println(BOLD + PURPLE + "┌─ Test " + testCount + ": " + description + RESET);

        long startTime = System.nanoTime();
        int[] result = solution.twoSumSorted(numbers, target);
        long endTime = System.nanoTime();

        double executionTime = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds

        System.out.println(CYAN + "│  Input:    " + RESET + formatInput(numbers, target));
        System.out.println(CYAN + "│  Expected: " + RESET + formatOutput(expected));
        System.out.println(CYAN + "│  Actual:   " + RESET + formatOutput(result));
        System.out.printf(CYAN + "│  Time:     " + RESET + "%.3f ms%n", executionTime);

        boolean passed = isEqual(result, expected);

        if (passed) {
            passCount++;
            System.out.println(CYAN + "│  Result:   " + BOLD + GREEN + "✓ PASS" + RESET);
        } else {
            System.out.println(CYAN + "│  Result:   " + BOLD + RED + "✗ FAIL" + RESET);
        }

        System.out.println(BOLD + PURPLE + "└" + "─".repeat(58) + RESET);
        System.out.println();
    }

    /**
     * Format input for display
     */
    private static String formatInput(int[] numbers, int target) {
        return YELLOW + "numbers=" + java.util.Arrays.toString(numbers) + ", target=" + target + RESET;
    }

    /**
     * Format output for display
     */
    private static String formatOutput(int[] output) {
        return YELLOW + java.util.Arrays.toString(output) + RESET;
    }

    /**
     * Check if two results are equal
     */
    private static boolean isEqual(int[] actual, int[] expected) {
        return java.util.Arrays.equals(actual, expected);
    }
}