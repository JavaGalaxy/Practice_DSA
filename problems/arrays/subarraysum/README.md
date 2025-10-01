# Subarray Sum Equals K

## Problem Description
Given an array of integers `nums` and an integer `k`, return the total number of continuous subarrays whose sum equals to `k`.

**Example 1:**
```
Input: nums = [1,1,1], k = 2
Output: 2
Explanation: [1,1] + [1,1] = 2 subarrays
```

**Example 2:**
```
Input: nums = [1,2,3], k = 3
Output: 2
Explanation: [1,2] + [3] = 2 subarrays
```

**Constraints:**
- `1 <= nums.length <= 2 * 10^4`
- `-1000 <= nums[i] <= 1000`
- `-10^7 <= k <= 10^7`

## Solution Approach

### Algorithm: Prefix Sum with HashMap
The key insight is to use prefix sums and HashMap to find subarrays efficiently. Instead of checking all possible subarrays (O(n²)), we can solve this in O(n) time.

### Implementation Details
- **Time Complexity**: O(n) - single pass through array
- **Space Complexity**: O(n) - HashMap to store prefix sum frequencies
- **Key Insight**: If `prefixSum[j] - prefixSum[i] = k`, then subarray from `i+1` to `j` has sum `k`

### Step-by-Step Example
For input `nums = [1, 1, 1], k = 2`:

1. **Initialize**: `prefixSumCount = {0: 1}`, `prefixSum = 0`, `count = 0`

2. **Process nums[0] = 1**:
   - `prefixSum = 0 + 1 = 1`
   - Check if `prefixSum - k = 1 - 2 = -1` exists in map → No
   - Add `prefixSumCount[1] = 1`
   - Map: `{0: 1, 1: 1}`

3. **Process nums[1] = 1**:
   - `prefixSum = 1 + 1 = 2`
   - Check if `prefixSum - k = 2 - 2 = 0` exists in map → Yes, count += 1
   - Add `prefixSumCount[2] = 1`
   - Map: `{0: 1, 1: 1, 2: 1}`, `count = 1`

4. **Process nums[2] = 1**:
   - `prefixSum = 2 + 1 = 3`
   - Check if `prefixSum - k = 3 - 2 = 1` exists in map → Yes, count += 1
   - Add `prefixSumCount[3] = 1`
   - Map: `{0: 1, 1: 1, 2: 1, 3: 1}`, `count = 2`

5. **Result**: 2 subarrays found: `[1,1]` (indices 0-1) and `[1,1]` (indices 1-2)

## Code Structure
```java
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        // Use HashMap to store prefix sum frequencies
        // Key insight: prefixSum[j] - prefixSum[i] = k
        // means subarray from i+1 to j has sum k
    }

    public int subarraySumBruteForce(int[] nums, int k) {
        // O(n²) alternative for comparison
    }
}
```

## Running the Code
```bash
javac *.java
java SubarraySumTest
```

**Expected Output:**
```
════════════════════════════════════════════════════════════
  Subarray Sum Equals K Tests
════════════════════════════════════════════════════════════

┌─ Test 1: Basic example
│  Input:    nums=[1, 1, 1], k=2
│  Expected: 2
│  Actual:   2
│  Time:     0.123 ms
│  Result:   ✓ PASS
└──────────────────────────────────────────────────────────
```

## Key Insights
- **Prefix Sum Optimization**: Convert O(n²) brute force to O(n) using prefix sums
- **HashMap for Frequency Tracking**: Store how many times each prefix sum occurs
- **Mathematical Relationship**: `prefixSum[j] - prefixSum[i] = k` identifies valid subarrays
- **Handle Edge Cases**: Initialize map with `{0: 1}` to handle subarrays starting from index 0
- **Negative Numbers**: Algorithm works with negative numbers unlike sliding window

## Algorithm Comparison

| Approach | Time | Space | Best For |
|----------|------|-------|----------|
| **HashMap + Prefix Sum** | O(n) | O(n) | **Optimal solution** |
| Brute Force | O(n²) | O(1) | Small arrays |
| Sliding Window | N/A | N/A | Won't work (negative numbers) |

## Related Problems
- **Subarray Sum Equals Zero** - Similar concept with k=0
- **Maximum Subarray Sum (Kadane's)** - Different objective, same prefix sum idea
- **Two Sum** - HashMap for target finding
- **Continuous Subarray Sum** - Modular arithmetic variation