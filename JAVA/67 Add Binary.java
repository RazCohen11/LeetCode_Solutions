/*
Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
 */

class Solution {
    public String addBinary(String a, String b) {
        int aBit = 0;
        int bBit = 0;
        int carry = 0;
        StringBuilder asb = new StringBuilder(a);
        StringBuilder bsb = new StringBuilder(b);
        StringBuilder ans = new StringBuilder();

        if (a.length() > b.length()) {
            while (asb.length() > bsb.length()) {
                bsb.insert(0, '0');
            }
        }
        else if (a.length() < b.length()) {
            while (asb.length() < bsb.length()) {
                asb.insert(0, '0');
            }
        }

        for (int i = asb.length() - 1; i >= 0; i --) {
            aBit = asb.charAt(i) - '0';
            bBit = bsb.charAt(i) - '0';
            int bitSum = aBit + bBit + carry;
            if (bitSum == 0 || bitSum == 1) {
                carry = 0;
                ans.insert(0, bitSum);
            }
            else {
                carry = 1;
                ans.insert(0, bitSum - 2);
            }
        }
        if (carry == 1) {
            ans.insert(0, carry);
        }

        return ans.toString();
    }
}