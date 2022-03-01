/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 * we need to know we can use Arrays.euqlas(arr1, arr2)
 */
import java.util.*;
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;
        int [] countS = new int [26];
        int [] countP = new int [26];
        for(int i = 0; i<p.length(); i++) {
            char temp = p.charAt(i);
            countP[temp - 'a']++;
        }
        int start =0, end = 0;
        while(end < s.length()) {
            char cur = s.charAt(end);
            countS[cur - 'a']++;
            if(end - start + 1 > p.length()) {
                countS[s.charAt(start++) - 'a']--;
            }
            if(end - start + 1 == p.length() && Arrays.equals(countP, countS)) {
                res.add(start);
            }
            end++;
        }
        return res;
    }
}
