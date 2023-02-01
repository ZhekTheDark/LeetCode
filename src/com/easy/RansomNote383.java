package com.easy;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 *
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 *
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 *
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 * Constraints:
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote383 {

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(1).
     * <p>
     * Runtime: 12 ms, faster than 59.40% of Java online submissions for Ransom Note.
     * Memory Usage: 42.7 MB, less than 67.45% of Java online submissions for Ransom Note.
     */
    /*
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> letters = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            Integer value = letters.get(c);
            if (value == null) {
                letters.put(c, 1);
            } else {
                letters.put(c, ++value);
            }
        }

        for (char c : ransomNote.toCharArray()) {
            Integer value = letters.get(c);
            if (value == null || value < 1) {
                return false;
            } else {
                letters.put(c, --value);
            }
        }

        return true;
    }
    */

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(1).
     * <p>
     * Runtime: 2 ms, faster than 99.2% of Java online submissions for Ransom Note.
     * Memory Usage: 42.6 MB, less than 75.7% of Java online submissions for Ransom Note.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];

        for (char c : magazine.toCharArray()) {
            letters[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (letters[c - 'a'] == 0) {
                return false;
            }
            letters[c - 'a']--;
        }

        return true;
    }
}
