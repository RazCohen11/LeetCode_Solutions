/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int tmp = 0;

        if (s.length() != t.length()) {
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            tmp = map.getOrDefault(s.charAt(i), 0) + 1;
            if (tmp == 0) {
                map.remove(s.charAt(i));
            }
            else {
                map.put(s.charAt(i), tmp);
            }

            tmp = map.getOrDefault(t.charAt(i), 0) - 1;
            if (tmp == 0) {
                map.remove(t.charAt(i));
            }
            else {
                map.put(t.charAt(i), tmp);
            }
        }

        if (map.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
}