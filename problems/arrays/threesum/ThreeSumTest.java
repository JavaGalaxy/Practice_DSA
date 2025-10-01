package arrays.threesum;

import java.util.Arrays;
import java.util.List;

/**
 * Test cases for ThreeSum
 */
public class ThreeSumTest {

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
        ThreeSum solution = new ThreeSum();

        printHeader("Three Sum Tests");

        // Test case 1: Your example with target 20
        testCase(solution, new int[]{3, 5, 61, 8, 19, 7}, 20, 1, "Target 20 - should find [5, 7, 8]");

        // Test case 2: Multiple solutions
        testCase(solution, new int[]{1, 2, 3, 4, 5, 6}, 10, 3, "Multiple triplets that sum to 10");

        // Test case 3: No solution
        testCase(solution, new int[]{1, 2, 3}, 100, 0, "No triplets sum to 100");

        // Test case 4: Array with duplicates
        testCase(solution, new int[]{-1, 0, 1, 2, -1, -4}, 0, 2, "Classic three sum with duplicates");

        // Test case 5: Edge case - exactly 3 elements
        testCase(solution, new int[]{1, 2, 3}, 6, 1, "Exactly 3 elements that sum to target");

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
    private static void testCase(ThreeSum solution, int[] nums, int target, int expectedCount, String description) {
        testCount++;

        System.out.println(BOLD + PURPLE + "┌─ Test " + testCount + ": " + description + RESET);

        long startTime = System.nanoTime();
        List<int[]> result = solution.threeSum(nums, target);
        long endTime = System.nanoTime();

        double executionTime = (endTime - startTime) / 1_000_000.0;

        System.out.println(CYAN + "│  Input:    " + RESET + formatInput(nums, target));
        System.out.println(CYAN + "│  Expected: " + RESET + expectedCount + " triplets");
        System.out.println(CYAN + "│  Actual:   " + RESET + formatOutput(result));
        System.out.printf(CYAN + "│  Time:     " + RESET + "%.3f ms%n", executionTime);

        boolean passed = result.size() == expectedCount;

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
    private static String formatInput(int[] nums, int target) {
        return YELLOW + "nums=" + Arrays.toString(nums) + ", target=" + target + RESET;
    }

    /**
     * Format output for display
     */
    private static String formatOutput(List<int[]> result) {
        StringBuilder sb = new StringBuilder();
        sb.append(YELLOW).append(result.size()).append(" triplets: [");
        for (int i = 0; i < result.size(); i++) {
            sb.append(Arrays.toString(result.get(i)));
            if (i < result.size() - 1) sb.append(", ");
        }
        sb.append("]").append(RESET);
        return sb.toString();
    }
}