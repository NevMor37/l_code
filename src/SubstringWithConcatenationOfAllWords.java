/**
 * You are given a string s and an array of strings words of the same length. Return all starting indices of
 * substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 *
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * Example 3:
 *
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lower-case English letters.
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] consists of lower-case English letters.
 */
import java.util.*;
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(String str : words) map.put(str, map.getOrDefault(str, 0) + 1);
        int wordLen = words[0].length();
        for(int i = 0; i<s.length() - wordLen * words.length + 1; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for(int j = i; j < i + wordLen * words.length; j += wordLen) {
                String sub = s.substring(j, j + wordLen);
                if(!copy.containsKey(sub)) break;
                int count = copy.get(sub);
                count--;
                if(count == 0) {
                    copy.remove(sub);
                } else {
                    copy.put(sub, count);
                }
                if(copy.size() == 0) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}
