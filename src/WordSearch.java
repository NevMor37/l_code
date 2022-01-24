/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 */
public class WordSearch {

    int [][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(dfs(board, 0, word, i, j, new boolean [m][n] )) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char [][] board, int index, String word, int x, int y, boolean [][] visited) {
        if(index == word.length()-1 && board[x][y] == word.charAt(index)) {
            return true;
        }
        if(board[x][y] != word.charAt(index)) {
            return false;
        }

        visited[x][y] = true;

        for(int [] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if(newX >= 0 && newX < board.length && newY >=0 && newY < board[0].length && !visited[newX][newY] ) {
                if(dfs(board, index + 1, word, newX, newY, visited)) {
                    return true;
                }
            }
        }

        visited[x][y] = false;
        return false;
    }

    public static void main(String ... args) {
        char [][] test = {{'a','a'}};
        WordSearch ws = new WordSearch();
        ws.exist(test, "aa");
    }
}
