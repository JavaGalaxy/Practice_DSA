package strings.firstunique;

/**
 * Test cases for FirstUnique
 */
public class FirstUniqueTest {

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
        FirstUnique solution = new FirstUnique();

        printHeader("First Unique Character Tests");

        // Test case 1: Basic example
        testCase(solution, "leetcode", 0, "Basic example");

        // Test case 2: All duplicates
        testCase(solution, "loveleetcode", 2, "Mixed duplicates");

        // Test case 3: No unique characters
        testCase(solution, "aabb", -1, "No unique characters");

        // Test case 4: Single character
        testCase(solution, "z", 0, "Single character");

        // Test case 5: All unique
        testCase(solution, "abcdef", 0, "All unique characters");

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
    private static void testCase(FirstUnique solution, String input, int expected, String description) {
        testCount++;

        System.out.println(BOLD + PURPLE + "┌─ Test " + testCount + ": " + description + RESET);

        long startTime = System.nanoTime();
        int result = solution.firstUniqChar(input);
        long endTime = System.nanoTime();

        double executionTime = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds

        System.out.println(CYAN + "│  Input:    " + RESET + "\"" + YELLOW + input + RESET + "\"");
        System.out.println(CYAN + "│  Expected: " + RESET + YELLOW + expected + RESET);
        System.out.println(CYAN + "│  Actual:   " + RESET + YELLOW + result + RESET);
        System.out.printf(CYAN + "│  Time:     " + RESET + "%.3f ms%n", executionTime);

        boolean passed = (result == expected);

        if (passed) {
            passCount++;
            System.out.println(CYAN + "│  Result:   " + BOLD + GREEN + "✓ PASS" + RESET);
        } else {
            System.out.println(CYAN + "│  Result:   " + BOLD + RED + "✗ FAIL" + RESET);
        }

        System.out.println(BOLD + PURPLE + "└" + "─".repeat(58) + RESET);
        System.out.println();
    }

}