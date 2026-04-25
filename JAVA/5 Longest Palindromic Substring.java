/*
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */

class Solution {
    public String longestPalindrome(String s) {
        int longestPal = 0;
        int start = 0;
        int end = 0;
        int d;
        int curPal = 0;

        for (int i = 0; i < s.length(); i++) {
            d = 1;
            curPal = 1;
            while (i + d < s.length() && i - d >= 0) {
                if (s.charAt(i + d) == s.charAt(i - d)) {
                    curPal += 2;
                    d++;
                }
                else {
                    break;
                }
            }
            d--;
            if (curPal > longestPal) {
                longestPal = curPal;
                start = i - d;
                end = i + d;
            }
        }

        for (int j = 0; j < s.length() - 1; j++) {
            d = 0;
            curPal = 0;
            while (j + 1 + d < s.length() && j - d >= 0) {
                if (s.charAt(j + 1 + d) == s.charAt(j - d)) {
                    curPal += 2;
                    d++;
                }
                else {
                    break;
                }
            }
            d--;
            if (curPal > longestPal) {
                longestPal = curPal;
                start = j - d;
                end = j + 1 + d;
            }
        }

        return s.substring(start, end + 1);
    }
}