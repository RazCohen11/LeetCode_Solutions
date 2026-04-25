/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            else if (stack.isEmpty()) {
                return false;
            }
            else if (s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
            }
            else if (s.charAt(i) == ']' && stack.peek() == '[') {
                stack.pop();
            }
            else if (s.charAt(i) == '}' && stack.peek() == '{') {
                stack.pop();
            }
            else {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
}