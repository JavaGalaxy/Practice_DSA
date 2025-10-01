// package strings.groupanagrams;

import java.util.*;

/**
 * Problem: Group Anagrams
 *
 * Time Complexity: O([TIME_COMPLEXITY])
 * Space Complexity: O([SPACE_COMPLEXITY])
 *
 * Description:
 * Given an array of strings strs, group all the anagrams together. An anagram is a word
 * formed by rearranging the letters of another, such as "cat" and "act". Return the
 * grouped anagrams as a list of lists, where each inner list contains strings that are
 * anagrams of each other. The order of the output does not matter.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["eat","tea","ate"],["tan","nat"],["bat"]]
 * Explanation: "eat", "tea", and "ate" are anagrams; "tan" and "nat" are anagrams;
 * "bat" is its own group.
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters only.
 */
public class GroupAnagrams {

    /**
     * Groups anagrams together from the given array of strings.
     *
     * @param strs Array of strings to group by anagrams
     * @return List of lists where each inner list contains anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String originalString : strs) {
            char[] chars = originalString.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);

            // Check if we've seen this sorted pattern before (i.e., anagrams exist)
            if(map.containsKey(sortedString)){
                // Anagram group already exists - add this string to the existing group
                // e.g., "eat" and "tea" both sort to "aet", so "tea" joins "eat"'s group
                List<String> existingGroup = map.get(sortedString);  // Get the existing list
                existingGroup.add(originalString);                   // Add current string to that list
            } else {
                // First time seeing this sorted pattern - create new anagram group
                // e.g., "bat" sorts to "abt" (new pattern), so create new group for "bat"
                List<String> newList = new ArrayList<>();
                newList.add(originalString);
                map.put(sortedString, newList);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> value : map.values()){
            result.add(value);
        }

        return result;
    }

    // Helper methods (if needed)

}