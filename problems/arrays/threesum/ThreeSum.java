package arrays.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Three Sum
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1) for sorting approach
 *
 * Description: Given an array of integers and a target sum, find all unique triplets
 * in the array that add up to the target. Each triplet should contain three different
 * elements from the array.
 */
public class ThreeSum {

    /**
     * Finds all unique triplets that sum to target
     *
     * @param nums array of integers
     * @param target the target sum
     * @return list of triplets that sum to target
     */
    public List<int[]> threeSum(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();

        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Early termination: if smallest possible sum > target
            if (nums[i] + nums[i + 1] + nums[i + 2] > target) break;

            // Early termination: if largest possible sum < target
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < target) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    result.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicates for second element
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for third element
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    /**
     * Alternative HashMap approach - useful when input is not sorted
     * Time: O(n^2), Space: O(n)
     */
    public List<int[]> threeSumHashMap(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();
        if (nums.length < 3) return result;

        Arrays.sort(nums); // Still need sorting for duplicate handling

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            java.util.Set<Integer> seen = new java.util.HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int complement = target - nums[i] - nums[j];

                if (seen.contains(complement)) {
                    result.add(new int[]{nums[i], complement, nums[j]});

                    // Skip duplicates
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
                }
                seen.add(nums[j]);
            }
        }

        return result;
    }

}