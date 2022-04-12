/**
 *
 *You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * words[i] and chars consist of lowercase English letters.
 */
public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int [] counts = new int [26];
        int res = 0;
        for(int i = 0; i<chars.length(); i++) counts[chars.charAt(i) - 'a']++;
        for(String str : words) {
            int [] comp = counts.clone();
            boolean canForm = true;
            for(int i = 0; i<str.length(); i++) {
                char c = str.charAt(i);
                if(comp[c - 'a'] <= 0) {
                    canForm = false;
                    break;
                }
                comp[c - 'a']--;
            }
            if(canForm) res+=str.length();
        }
        return res;
    }
}