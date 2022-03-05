/**
 * You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 *
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 *
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2]]
 * Output: "bacd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[1] and s[2], s = "bacd"
 * Example 2:
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * Output: "abcd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[0] and s[2], s = "acbd"
 * Swap s[1] and s[2], s = "abcd"
 * Example 3:
 *
 * Input: s = "cba", pairs = [[0,1],[1,2]]
 * Output: "abc"
 * Explaination:
 * Swap s[0] and s[1], s = "bca"
 * Swap s[1] and s[2], s = "bac"
 * Swap s[0] and s[1], s = "abc"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s only contains lower case English letters.
 */
import java.util.*;
public class SmallestStringWithSwaps {
    Map<Integer, PriorityQueue<Character>> map;
    int [] list;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        map = new HashMap<>();
        list = new int [s.length()];
        for(int i=0; i<list.length; i++) list[i] = i;
        for(List<Integer> pair : pairs) {
            int start = pair.get(0);
            int end = pair.get(1);
            union(start, end);
        }
        for(int i = 0; i<s.length(); i++) {
            char cur = s.charAt(i);
            int root = find(i);
            if(!map.containsKey(root)) {
                map.put(root, new PriorityQueue<>());
            }
            map.get(root).offer(cur);
        }
        char [] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++) {
            int root = find(i);
            chars[i] = map.get(root).poll();
        }
        return String.valueOf(chars);
    }

    public int find(int a) {
        if(list[a] != a) {
            return find(list[a]);
        }
        return a;
    }

    public void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if(parentA < parentB) {
            list[parentB] = parentA;
        } else {
            list[parentA] = parentB;
        }
    }

}
