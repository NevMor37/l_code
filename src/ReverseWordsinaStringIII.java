/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 *
 * Input: s = "God Ding"
 * Output: "doG gniD"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 */
public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        char [] chars = s.toCharArray();
        int start = 0, end = 0;
        while(end < s.length()) {
            while(end < chars.length && chars [end] != ' ') end++;
            reverseString(chars, start, end -1);
            start = end +1;
            end = end +1;
        }
        return String.valueOf(chars);
    }

    public void reverseString(char [] s, int start, int end) {
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            end--;
            start++;
        }
    }
}
