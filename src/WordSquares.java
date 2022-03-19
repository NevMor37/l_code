/**
 * Given an array of unique strings words, return all the word squares you can build from words. The same word from words can be used multiple times.
 * You can return the answer in any order.
 *
 * A sequence of strings forms a valid word square if the kth row and column read the same string, where 0 <= k < max(numRows, numColumns).
 *
 * For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
 *
 *
 * Example 1:
 *
 * Input: words = ["area","lead","wall","lady","ball"]
 * Output: [["ball","area","lead","lady"],["wall","area","lead","lady"]]
 * Explanation:
 * The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 * Example 2:
 *
 * Input: words = ["abat","baba","atan","atal"]
 * Output: [["baba","abat","baba","atal"],["baba","abat","baba","atan"]]
 * Explanation:
 * The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 4
 * All words[i] have the same length.
 * words[i] consists of only lowercase English letters.
 * All words[i] are unique.
 */
import java.util.*;
public class WordSquares {
    List<List<String>> res;
    Map<String, List<String>> map;
    public List<List<String>> wordSquares(String[] words) {
        res = new ArrayList<>();
        map = new HashMap<>();
        if(words == null || words.length == 0) return res;
        for(String str : words) {
            for(int i = 0; i<str.length(); i++) {
                String prefix = str.substring(0, i + 1);
                if(!map.containsKey(prefix)) {
                    map.put(prefix, new ArrayList<>());
                }
                map.get(prefix).add(str);
            }
        }
        for(int i = 0; i<words.length; i++) {
            List<String> subRes = new ArrayList<>();
            subRes.add(words[i]);
            backtrack(1, words[i], subRes);
        }
        return res;
    }

    public void backtrack(int step, String word, List<String> subRes) {
        if(subRes.size() == word.length()) {
            res.add(new ArrayList<>(subRes));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(String str : subRes) {
            sb.append(str.charAt(step));
        }
        String prefix = sb.toString();
        if(!map.containsKey(prefix)) return;
        List<String> prefixes = map.get(prefix);
        for(int i = 0; i<prefixes.size(); i++) {
            subRes.add(prefixes.get(i));
            backtrack(step + 1, word, subRes);
            subRes.remove(subRes.size()-1);
        }
    }


    class Solution {
        class TrieNode {
            String word;
            TrieNode [] children = new TrieNode[26];
        }

        TrieNode root;
        List<List<String>> res;
        public List<List<String>> wordSquares(String[] words) {
            res = new ArrayList<>();
            buildPrefixTree(words);
            for(int i = 0; i<words.length; i++) {
                List<String> subRes = new ArrayList<>();
                subRes.add(words[i]);
                backtrack1(1, words[i], subRes);
            }
            return res;
        }

        public void buildPrefixTree(String [] words) {
            this.root = new TrieNode();
            for(String str : words) {
                TrieNode node = this.root;
                for(int i = 0; i<str.length(); i++) {
                    char c = str.charAt(i);
                    if(node.children[c - 'a'] == null) {
                        node.children[c - 'a'] = new TrieNode();
                    }
                    node = node.children[c - 'a'];
                }
                node.word = str;
            }
        }
        public List<String> findPrefixString(String str) {
            List<String> res = new ArrayList<>();
            TrieNode node = this.root;
            for(int i = 0; i<str.length(); i++) {
                char c = str.charAt(i);
                if(node.children[c - 'a'] == null) {
                    return res;
                }
                node = node.children[c - 'a'];
            }
            dfs(node, res);
            return res;
        }

        public void dfs(TrieNode node, List<String> res) {
            if(node.word != null) {
                res.add(node.word);
                return;
            }
            for(int i = 0; i<26; i++) {
                if(node.children[i] != null) {
                    dfs(node.children[i], res);
                }
            }
        }
        public void backtrack1(int step, String word, List<String> subRes) {
            if(subRes.size() == word.length()) {
                res.add(new ArrayList<>(subRes));
                return;
            }
            StringBuilder sb = new StringBuilder();
            for(String str : subRes) {
                sb.append(str.charAt(step));
            }
            String prefix = sb.toString();
            List<String> prefixes = findPrefixString(prefix);
            if(prefixes.size() == 0) return;
            for(int i = 0; i<prefixes.size(); i++) {
                subRes.add(prefixes.get(i));
                backtrack1(step + 1, word, subRes);
                subRes.remove(subRes.size()-1);
            }
        }
    }
}
