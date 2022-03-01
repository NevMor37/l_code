/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 *
 * Example 1:
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 */
import java.util.*;
public class ImplementTrie {
}

class Trie {
    class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        String word;
    }
    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = this.root;
        char [] chars = word.toCharArray();
        for(int i=0; i<chars.length; i++) {
            char cur = chars[i];
            if(!node.map.containsKey(cur)) {
                TrieNode temp = new TrieNode();
                node.map.put(cur, temp);
            }
            node = node.map.get(cur);
        }
        node.word = word;
    }

    public boolean search(String word) {
        TrieNode node = this.root;
        char [] chars = word.toCharArray();
        for(int i=0; i<chars.length; i++) {
            char cur = chars[i];
            if(node.map.containsKey(cur)) {
                node = node.map.get(cur);
            } else {
                return false;
            }
        }
        if(node.word == null) return false;
        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = this.root;
        char [] chars = prefix.toCharArray();
        for(int i=0; i<chars.length; i++) {
            char cur = chars[i];
            if(node.map.containsKey(cur)) {
                node = node.map.get(cur);
            } else {
                return false;
            }
        }
        return node.word != null || node.map.size() != 0;
    }
}
