/*
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings respectively, such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

 

Example 1:


Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Explanation: One way to obtain s3 is:
Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
Since s3 can be obtained by interleaving s1 and s2, we return true.
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true
 */

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        if (s1.length() > 0 && s3.charAt(0) == s1.charAt(0)) {
            dp[1][0] = 1;
        }
        if (s2.length() > 0 && s3.charAt(0) == s2.charAt(0)) {
            dp[0][1] = 1;
        }
        if (s1.length() > 0 && s2.length() > 0 && dp[1][0] == 0 && dp[0][1] == 0) {
            return false;
        }
        if (s1.equals("") && s2.equals("") && s3.equals("")) {
            return true;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                if (dp[i][j] > 0) {
                    if (i != s1.length() && s3.charAt(dp[i][j]) == s1.charAt(i)) {
                        dp[i + 1][j] = dp[i][j] + 1;
                    }
                    if (j != s2.length() && s3.charAt(dp[i][j]) == s2.charAt(j)) {
                        dp[i][j + 1] = dp[i][j] + 1;
                    }
                }
            }
        }

        if (dp[s1.length()][s2.length()] == s3.length()) {
            return true;
        }
        else {
            return false;
        }
    }
}