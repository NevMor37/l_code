/**
 * You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.
 *
 * Return the maximum possible length of s.
 *
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All the valid concatenations are:
 * - ""
 * - "un"
 * - "iq"
 * - "ue"
 * - "uniq" ("un" + "iq")
 * - "ique" ("iq" + "ue")
 * Maximum length is 4.
 * Example 2:
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * Explanation: The only string in arr has all 26 characters.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lowercase English letters.
 */
import java.util.*;
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    int res = 0;

    public int maxLength(List<String> arr) {
        backtrack("", arr, 0);
        return res;
    }

    public void backtrack(String cur, List<String> arr, int index) {
        if(cur.length() > res) res = cur.length();
        if(index == arr.size()) return;
        String add = cur + arr.get(index);
        if(!containsDuplicate(add)) {
            backtrack(add, arr, index + 1);
        }
        backtrack(cur, arr, index + 1);
    }

    public boolean containsDuplicate(String s) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i<s.length(); i++) {
            if(!set.add(s.charAt(i))) return true;
        }
        return false;
    }
}
