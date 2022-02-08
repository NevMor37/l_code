/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * Example 2:
 *
 *
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 */
import java.util.*;
public class WordSearchII {
    public class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word;
    }
    char [][] board;
    TrieNode root;
    List<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        buildTrie(words);
        res = new ArrayList<>();
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[0].length; j++) {
                if(this.root.children.containsKey(board[i][j])) {
                    TrieNode node = this.root;
                    dfs(i, j, node);
                }
            }
        }
        return res;
    }
    public void buildTrie(String [] words) {
        this.root = new TrieNode();
        for(String str : words) {
            TrieNode node = root;
            for(int i=0; i<str.length(); i++) {
                char temp = str.charAt(i);
                if(!node.children.containsKey(temp)) {
                    TrieNode childNode = new TrieNode();
                    node.children.put(temp, childNode);
                }
                node = node.children.get(temp);
            }
            node.word = str;
        }
    }
    int [][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public void dfs(int x, int y, TrieNode node) {
        char cur = this.board[x][y];
        TrieNode curNode = node.children.get(cur);
        if(curNode.word != null) {
            this.res.add(curNode.word);
            curNode.word = null;
        }
        //to avoid duplicate visit
        this.board[x][y] = '#';
        for(int [] direction : directions) {
            int newX = direction[0] + x;
            int newY = direction[1] + y;
            if(newX >= 0 && newX <board.length && newY >=0 && newY <board[0].length && curNode.children.containsKey(this.board[newX][newY])) {
                dfs(newX, newY, curNode);
            }
        }
        this.board[x][y] = cur;
        if (curNode.children.isEmpty()) {
            node.children.remove(cur);
        }
    }

}
