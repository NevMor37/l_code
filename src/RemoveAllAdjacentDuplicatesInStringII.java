import java.util.*;

/**
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them,
 * causing the left and the right side of the deleted substring to concatenate together.
 *
 * We repeatedly make k duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * Example 2:
 *
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * Example 3:
 *
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * 2 <= k <= 104
 * s only contains lower case English letters.
 */
public class RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
                countStack.push(1);
            } else if(stack.peek() == c) {
                if(countStack.peek() == k - 1) {
                    for(int j = 0; j<k-1; j++) {
                        stack.pop();
                        countStack.pop();
                    }
                } else {
                    stack.push(c);
                    countStack.push(countStack.peek() + 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
