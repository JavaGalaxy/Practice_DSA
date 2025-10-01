package arrays.subarraysum;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Subarray Sum Equals K
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Description: Given an array of integers and an integer k,
 * find the total number of continuous subarrays whose sum equals k.
 */
public class SubarraySum {

    /**
     * Count subarrays with sum equal to k using prefix sum and HashMap
     *
     * @param nums array of integers
     * @param k target sum
     * @return number of subarrays with sum equal to k
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Handle case where prefix sum equals k

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            // Check if (prefixSum - k) exists in map
            // If it does, we found subarrays ending at current position
            if (prefixSumCount.containsKey(prefixSum - k)) {
                count += prefixSumCount.get(prefixSum - k);
            }

            // Add current prefix sum to map
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    /**
     * Alternative brute force approach for comparison
     * Time: O(n^2), Space: O(1)
     */
    public int subarraySumBruteForce(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

}