// package strings.groupanagrams;

import java.util.*;

/**
 * Test cases for GroupAnagrams
 */
public class GroupAnagramsTest {

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
        GroupAnagrams solution = new GroupAnagrams();

        printHeader("Group Anagrams Tests");

        // Test case 1: Basic example from problem description
        testCase(solution,
            new String[]{"eat","tea","tan","ate","nat","bat"},
            Arrays.asList(
                Arrays.asList("eat","tea","ate"),
                Arrays.asList("tan","nat"),
                Arrays.asList("bat")
            ),
            "Basic example with multiple anagram groups");

        // Test case 2: Single empty string
        testCase(solution,
            new String[]{""},
            Arrays.asList(
                Arrays.asList("")
            ),
            "Single empty string");

        // Test case 3: Single character
        testCase(solution,
            new String[]{"a"},
            Arrays.asList(
                Arrays.asList("a")
            ),
            "Single character string");

        // Test case 4: No anagrams (all unique)
        testCase(solution,
            new String[]{"ab","ba","abc","def"},
            Arrays.asList(
                Arrays.asList("ab","ba"),
                Arrays.asList("abc"),
                Arrays.asList("def")
            ),
            "Mix of anagrams and unique strings");

        // Test case 5: All strings are anagrams
        testCase(solution,
            new String[]{"abc","bca","cab","acb"},
            Arrays.asList(
                Arrays.asList("abc","bca","cab","acb")
            ),
            "All strings are anagrams of each other");

        // Test case 6: Different length strings
        testCase(solution,
            new String[]{"a","aa","aaa"},
            Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("aa"),
                Arrays.asList("aaa")
            ),
            "Different length strings (no anagrams)");

        // Test case 7: Case with repeated letters
        testCase(solution,
            new String[]{"aab","aba","baa","ab","ba"},
            Arrays.asList(
                Arrays.asList("aab","aba","baa"),
                Arrays.asList("ab","ba")
            ),
            "Strings with repeated letters");

        // Test case 8: Single letters forming anagrams
        testCase(solution,
            new String[]{"a","b","a","c","b"},
            Arrays.asList(
                Arrays.asList("a","a"),
                Arrays.asList("b","b"),
                Arrays.asList("c")
            ),
            "Duplicate single character strings");

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
    private static void testCase(GroupAnagrams solution, String[] strs, List<List<String>> expected, String description) {
        testCount++;

        System.out.println(BOLD + PURPLE + "┌─ Test " + testCount + ": " + description + RESET);

        long startTime = System.nanoTime();
        List<List<String>> result = solution.groupAnagrams(strs);
        long endTime = System.nanoTime();

        double executionTime = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds

        System.out.println(CYAN + "│  Input:    " + RESET + formatInput(strs));
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
    private static String formatInput(String[] strs) {
        return YELLOW + Arrays.toString(strs) + RESET;
    }

    /**
     * Format output for display
     */
    private static String formatOutput(List<List<String>> output) {
        if (output == null) {
            return YELLOW + "null" + RESET;
        }
        return YELLOW + output.toString() + RESET;
    }

    /**
     * Check if two results are equal (order-independent comparison)
     * Since the order of groups and order within groups doesn't matter,
     * we need to normalize both results before comparison
     */
    private static boolean isEqual(List<List<String>> actual, List<List<String>> expected) {
        if (actual == null && expected == null) return true;
        if (actual == null || expected == null) return false;
        if (actual.size() != expected.size()) return false;

        // Normalize both lists: sort strings within each group, then sort groups
        List<Set<String>> actualSets = new ArrayList<>();
        List<Set<String>> expectedSets = new ArrayList<>();

        for (List<String> group : actual) {
            actualSets.add(new HashSet<>(group));
        }

        for (List<String> group : expected) {
            expectedSets.add(new HashSet<>(group));
        }

        // Check if all expected sets are present in actual sets
        for (Set<String> expectedSet : expectedSets) {
            boolean found = false;
            for (Set<String> actualSet : actualSets) {
                if (actualSet.equals(expectedSet)) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }

        // Check if all actual sets are present in expected sets
        for (Set<String> actualSet : actualSets) {
            boolean found = false;
            for (Set<String> expectedSet : expectedSets) {
                if (expectedSet.equals(actualSet)) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }

        return true;
    }
}