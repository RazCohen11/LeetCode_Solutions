/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> freq = new HashMap<>();
        char c;
        for (int i = 0; i < magazine.length(); i++) {
            c = magazine.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (int j = 0; j < ransomNote.length(); j++) {
            c = ransomNote.charAt(j);
            freq.put(c, freq.getOrDefault(c, 0) - 1);
            if (freq.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
}