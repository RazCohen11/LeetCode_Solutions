/*
Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
 

Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified because it contains only one word.
Example 3:

Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 

Constraints:

1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth
 */

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        List<String> output = new ArrayList<>();
        int wordCount = 0;
        int charCount = 0;

        for (int i = 0; i < words.length; i++) {
            if (charCount + wordCount + words[i].length() <= maxWidth) {
                wordCount++;
                charCount += words[i].length();
            }
            else if (wordCount == 1) {
                sb.append(words[i - wordCount]);
                sb.append(" ".repeat(maxWidth - charCount));
                output.add(sb.toString());
                sb.setLength(0);
                wordCount = 1;
                charCount = words[i].length();
            }
            else {
                int spaces = maxWidth - charCount;
                int mod = spaces % (wordCount - 1);
                for (int j = 0; j < wordCount - 1; j++) {
                    sb.append(words[i + j - wordCount]);
                    sb.append(" ".repeat(spaces / (wordCount - 1)));
                    if (j < mod) {
                        sb.append(" ");
                    }
                }
                sb.append(words[i - 1]);
                output.add(sb.toString());
                sb.setLength(0);
                wordCount = 1;
                charCount = words[i].length();
            }
        }
        for (int k = 0; k < wordCount - 1; k++) {
            sb.append(words[words.length + k - wordCount]);
            sb.append(" ");
        }
        sb.append(words[words.length - 1]);
        sb.append(" ".repeat(maxWidth - charCount - wordCount + 1));
        output.add(sb.toString());

        return output;
    }
}