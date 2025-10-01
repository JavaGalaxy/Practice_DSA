package arrays.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Two Sum
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Description: Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 */
public class TwoSum {

    /**
     * Finds two numbers in the array that add up to the target sum.
     *
     * @param nums array of integers
     * @param target the target sum
     * @return array containing indices of the two numbers that add up to target
     */
    // Input = [2, 7, 11, 15]
    // Target = 9
    // Output = [0, 1]

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0; i < nums.length; i++){
            int complement = target - nums[i];

            if(hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), i};
            } else {
                hashMap.put(nums[i], i);
            }

        }

        return new int[0];
    }

}