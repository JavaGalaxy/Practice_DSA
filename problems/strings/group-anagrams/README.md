# Group Anagrams

## Problem Description

Given an array of strings `strs`, group all the anagrams together. An anagram is a word formed by rearranging the letters of another, such as "cat" and "act". Return the grouped anagrams as a list of lists, where each inner list contains strings that are anagrams of each other. The order of the output does not matter.

## Examples

### Example 1
```
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["eat","tea","ate"],["tan","nat"],["bat"]]
Explanation: "eat", "tea", and "ate" are anagrams; "tan" and "nat" are anagrams; "bat" is its own group.
```

### Example 2
```
Input: strs = [""]
Output: [[""]]
```

### Example 3
```
Input: strs = ["a"]
Output: [["a"]]
```

## Constraints

- `1 <= strs.length <= 10^4`
- `0 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters only.

## Key Insights

1. **Anagram Definition**: Two strings are anagrams if they contain the same characters with the same frequency.

2. **Grouping Strategy**: We need a way to identify which strings belong to the same anagram group.

3. **Order Independence**: The order of groups in the output doesn't matter, and the order of strings within each group doesn't matter.

## Possible Approaches

### Approach 1: Sorting
- For each string, sort its characters to create a "canonical" form
- Use this canonical form as a key to group anagrams
- Time Complexity: O(N * M log M) where N is number of strings, M is average string length
- Space Complexity: O(N * M)

### Approach 2: Character Count
- For each string, count the frequency of each character
- Use this frequency pattern as a key to group anagrams
- Time Complexity: O(N * M) where N is number of strings, M is average string length
- Space Complexity: O(N * M)

## Files

- `GroupAnagrams.java` - Main solution class with method signature
- `GroupAnagramsTest.java` - Comprehensive test cases
- `README.md` - This file with problem description and hints

## Usage

### Compile and Run Tests
```bash
# From the group-anagrams directory
javac -d ../../../build *.java
java -cp ../../../build GroupAnagramsTest
```

### Test Cases Included

1. **Basic Example**: Multiple anagram groups from problem description
2. **Edge Cases**: Empty string, single character
3. **No Anagrams**: Mix of anagrams and unique strings
4. **All Anagrams**: All strings are anagrams of each other
5. **Different Lengths**: Strings of different lengths (no anagrams possible)
6. **Repeated Letters**: Handling strings with repeated characters
7. **Duplicates**: Handling duplicate strings in input

## Implementation Notes

- The solution should handle empty strings correctly
- Order of output groups doesn't matter
- Order of strings within each group doesn't matter
- Consider edge cases like empty input, single string, etc.
- Think about the most efficient approach for your solution