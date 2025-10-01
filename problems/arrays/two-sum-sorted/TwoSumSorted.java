// package arrays.twosumsorted;

/**
 * Problem: [PROBLEM_TITLE]
 *
 * Time Complexity: O([TIME_COMPLEXITY])
 * Space Complexity: O([SPACE_COMPLEXITY])
 *
 * Description:
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Return the indices of the two numbers as an array [index1, index2] (1-indexed).
 * You may assume that each input has exactly one solution, and you may not use the same element twice. Optimize for time complexity.
 *
 * Example:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [2,7]
 *
 * Explanation: The numbers at indices 1 and 2 (2 + 7 = 9).
 *
 * Constraints:
 * 2 <= numbers.length <= 3 * 10^4
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 */
public class TwoSumSorted {

    public int[] twoSumSorted(int[] nums, int target) {
    //  numbers = [2,7,11,15], target = 9
        int left = 0;
        int right = nums.length -1;

        while(left < right){
            if(nums[left]+nums[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if(nums[left] + nums[right] > target ){
                right--;
            } else {
                left++;
            }
        }

        return new int[] {-1, -1};
    }

    // Helper methods (if needed)

}