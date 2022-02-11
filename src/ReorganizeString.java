import java.util.*;
/**
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
 *
 * Return any possible rearrangement of s or return "" if not possible.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: "aba"
 * Example 2:
 *
 * Input: s = "aaab"
 * Output: ""
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 */
public class ReorganizeString {
    public String reorganizeString(String s) {
        Map<Character, Pair> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        for(int i = 0; i<s.length(); i++) {
            char temp = s.charAt(i);
            if(!map.containsKey(temp)) {
                Pair p = new Pair();
                p.c = temp;
                p.count = 1;
                map.put(temp, p);
            } else {
                ++map.get(temp).count;
            }
        }
        for(Pair p : map.values()) {
            pq.offer(p);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair p1 = pq.poll();
            if(sb.length() == 0 || sb.charAt(sb.length()-1) != p1.c) {
                sb.append(p1.c);
                p1.count--;
                if(p1.count > 0) pq.offer(p1);
            } else {
                if(pq.size() == 0) {
                    return "";
                }
                Pair p2 = pq.poll();
                sb.append(p2.c);
                p2.count--;
                if(p2.count >0) pq.offer(p2);
                pq.offer(p1);
            }
        }
        return sb.toString();
    }
    class Pair {
        char c;
        int count;
    }
}
