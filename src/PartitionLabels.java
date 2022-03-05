/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 *
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 *
 * Return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 *
 * Input: s = "eccbbbbdec"
 * Output: [10]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 */
import java.util.*;
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int [] lastOccurance = new int [26];
        char [] chars = s.toCharArray();
        for(int i= 0; i<chars.length; i++) {
            char cur = chars[i];
            lastOccurance[cur - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while(i < s.length()) {
            int lastSeen = lastOccurance[chars[i] - 'a'];
            int j = i;
            while(j < lastSeen) {
                lastSeen = Math.max(lastSeen, lastOccurance[chars[j]- 'a']);
                j++;
            }
            int len = j - i + 1;
            res.add(len);
            i = j;
            i++;
        }
        return res;
    }
}
