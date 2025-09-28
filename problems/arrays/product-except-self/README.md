# Product of Array Except Self

## Problem Description
Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

**Constraints:**
- The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer
- Must run in O(n) time complexity
- Cannot use the division operation

## Solution Approach

### Algorithm: Two-Pass Method
The solution uses a two-pass approach to calculate products without division:

1. **Left Pass**: Calculate the product of all elements to the left of each index
2. **Right Pass**: Multiply by the product of all elements to the right of each index

### Implementation Details
- **Time Complexity**: O(n) - Two passes through the array
- **Space Complexity**: O(1) extra space (output array doesn't count)
- **Key Variables**:
  - `answer[]`: Stores left products first, then final results
  - `rightProduct`: Running product from right to left

### Step-by-Step Example
For input `[1, 2, 3, 4]`:

**After Left Pass**: `[1, 1, 2, 6]`
- answer[0] = 1 (no elements to the left)
- answer[1] = 1 (product of [1])
- answer[2] = 2 (product of [1, 2])
- answer[3] = 6 (product of [1, 2, 3])

**After Right Pass**: `[24, 12, 8, 6]`
- answer[3] = 6 × 1 = 6 (rightProduct = 1)
- answer[2] = 2 × 4 = 8 (rightProduct = 4)
- answer[1] = 1 × 12 = 12 (rightProduct = 3×4 = 12)
- answer[0] = 1 × 24 = 24 (rightProduct = 2×3×4 = 24)

## Code Structure
```java
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // Two-pass algorithm implementation
    }

    public static void main(String[] args) {
        // Test case with [1, 2, 3, 4]
    }
}
```

## Running the Code
```bash
javac ProductExceptSelf.java
java ProductExceptSelf
```

**Expected Output:**
```
Input: [1, 2, 3, 4]
Output: [24, 12, 8, 6]
```

## Key Insights
- Avoids division by decomposing the problem into left and right products
- Uses the output array to store intermediate results, minimizing space usage
- The `rightProduct` variable eliminates the need for a separate right products array