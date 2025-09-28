public class ProductExceptSelfTest {
    public static void main(String[] args) {
        ProductExceptSelf solution = new ProductExceptSelf();

        // Test case 1: Basic example
        testCase(solution, new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}, "Basic example");

        // Test case 2: Array with zero
        testCase(solution, new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0}, "Array with zero");

        // Test case 3: All ones
        testCase(solution, new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}, "All ones");

        // Test case 4: Two elements
        testCase(solution, new int[]{2, 3}, new int[]{3, 2}, "Two elements");

        System.out.println("All tests completed!");
    }

    private static void testCase(ProductExceptSelf solution, int[] input, int[] expected, String description) {
        System.out.println("\nTest: " + description);

        int[] result = solution.productExceptSelf(input);

        System.out.print("Input:    [");
        printArray(input);
        System.out.println("]");

        System.out.print("Expected: [");
        printArray(expected);
        System.out.println("]");

        System.out.print("Actual:   [");
        printArray(result);
        System.out.println("]");

        boolean passed = arrayEquals(result, expected);
        System.out.println("Result: " + (passed ? "PASS" : "FAIL"));
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
    }

    private static boolean arrayEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}