/**
 * We can shift a string by shifting each of its letters to its successive letter.
 *
 * For example, "abc" can be shifted to be "bcd".
 * We can keep shifting the string to form a sequence.
 *
 * For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" -> ... -> "xyz".
 * Given an array of strings strings, group all strings[i] that belong to the same shifting sequence. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: strings = ["abc","bcd","acef","xyz","az","ba","a","z"]
 * Output: [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]
 * Example 2:
 *
 * Input: strings = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strings.length <= 200
 * 1 <= strings[i].length <= 50
 * strings[i] consists of lowercase English letters.
 */
import java.security.KeyStore;
import java.util.*;
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strings) {
            int offset = str.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<str.length(); i++) {
                int val = str.charAt(i) - offset;
                sb.append((char)(val >= 'a' ? val : val + 26));
            }
            String key = sb.toString();
            if(map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> sublist : map.values()) {
            res.add(sublist);
        }
        return res;
    }

    public static void main(String ...args) {
        GroupShiftedStrings g = new GroupShiftedStrings();
        String [] test = {"abc","bcd","acef","xyz","az","ba","a","z"};
        System.out.println(g.groupStrings(test));
        System.out.println(Integer.valueOf('a'));
        System.out.println(Integer.valueOf('A'));
    }
}
