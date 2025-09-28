package arrays.twosum;

import java.util.Arrays;

/**
 * Test cases for TwoSum
 */
public class TwoSumTest {

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
        TwoSum solution = new TwoSum();

        printHeader("Two Sum Problem Tests");

        // Test case 1: Basic example
        testCase(solution, new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}, "Basic example");

        // Test case 2: Multiple valid pairs
        testCase(solution, new int[]{3, 2, 4}, 6, new int[]{1, 2}, "Multiple valid pairs");

        // Test case 3: Same number twice
        testCase(solution, new int[]{3, 3}, 6, new int[]{0, 1}, "Same number twice");

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
    private static void testCase(TwoSum solution, int[] nums, int target, int[] expected, String description) {
        testCount++;

        System.out.println(BOLD + PURPLE + "┌─ Test " + testCount + ": " + description + RESET);

        long startTime = System.nanoTime();
        int[] result = solution.twoSum(nums, target);
        long endTime = System.nanoTime();

        double executionTime = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds

        System.out.println(CYAN + "│  Input:    " + RESET + "nums=" + formatArray(nums) + ", target=" + YELLOW + target + RESET);
        System.out.println(CYAN + "│  Expected: " + RESET + formatArray(expected));
        System.out.println(CYAN + "│  Actual:   " + RESET + formatArray(result));
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
     * Format array with nice brackets and spacing
     */
    private static String formatArray(int[] arr) {
        if (arr == null) return YELLOW + "null" + RESET;
        if (arr.length == 0) return YELLOW + "[]" + RESET;

        StringBuilder sb = new StringBuilder();
        sb.append(YELLOW).append("[").append(RESET);

        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(BOLD).append(arr[i]).append(RESET);
        }

        sb.append(YELLOW).append("]").append(RESET);
        return sb.toString();
    }

    /**
     * Check if two results are equal
     */
    private static boolean isEqual(int[] actual, int[] expected) {
        return Arrays.equals(actual, expected);
    }
}