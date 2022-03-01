/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */
import java.util.*;
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<s1.length(); i++) {
            char c= s1.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        int start = 0, end = 0;
        while(end < s2.length()) {
            char c = s2.charAt(end);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
            if(end - start + 1 > s1.length()) {
                char sc = s2.charAt(start++);
                int freq = map2.get(sc);
                freq--;
                if(freq == 0) {
                    map2.remove(sc);
                } else {
                    map2.put(sc, freq);
                }
            }
            if(end - start + 1 == s1.length()) {
                if(map1.equals(map2)) {
                    return true;
                }
            }
            end++;
        }
        return false;
    }
}
