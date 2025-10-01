package strings.firstunique;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Problem: First Unique Character in a String
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) - at most 26 lowercase letters
 *
 * Description: Given a string s, find the first non-repeating character
 * in it and return its index. If it doesn't exist, return -1.
 */
public class FirstUnique {

    /**
     * Find first unique character using HashMap (two passes)
     *
     * @param s input string
     * @return index of first unique character, -1 if none exists
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        // First pass: count character frequencies
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Second pass: find first character with count 1
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Find first unique character using LinkedHashMap (single pass)
     * LinkedHashMap maintains insertion order
     */
    public int firstUniqCharLinkedMap(String s) {
        Map<Character, Integer> charIndex = new LinkedHashMap<>();
        Map<Character, Boolean> seen = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (seen.containsKey(c)) {
                // Character is duplicate, remove from LinkedHashMap
                charIndex.remove(c);
            } else {
                // First occurrence, add to both maps
                charIndex.put(c, i);
                seen.put(c, true);
            }
        }

        // Return the first entry in LinkedHashMap (if any)
        return charIndex.isEmpty() ? -1 : charIndex.values().iterator().next();
    }

    /**
     * Array-based solution for lowercase letters only
     * Most efficient for ASCII lowercase letters
     */
    public int firstUniqCharArray(String s) {
        int[] charCount = new int[26];

        // Count frequencies
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Find first unique
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

}