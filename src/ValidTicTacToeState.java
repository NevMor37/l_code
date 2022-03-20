/**
 * Given a Tic-Tac-Toe board as a string array board, return true if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.
 *
 * The board is a 3 x 3 array that consists of characters ' ', 'X', and 'O'. The ' ' character represents an empty square.
 *
 * Here are the rules of Tic-Tac-Toe:
 *
 * Players take turns placing characters into empty squares ' '.
 * The first player always places 'X' characters, while the second player always places 'O' characters.
 * 'X' and 'O' characters are always placed into empty squares, never filled ones.
 * The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 *
 *
 * Example 1:
 *
 *
 * Input: board = ["O  ","   ","   "]
 * Output: false
 * Explanation: The first player always plays "X".
 * Example 2:
 *
 *
 * Input: board = ["XOX"," X ","   "]
 * Output: false
 * Explanation: Players take turns making moves.
 * Example 3:
 *
 *
 * Input: board = ["XOX","O O","XOX"]
 * Output: true
 *
 *
 * Constraints:
 *
 * board.length == 3
 * board[i].length == 3
 * board[i][j] is either 'X', 'O', or ' '.
 *
 * at most one winner
 * num of X has to be greater than or equal O
 * if O win, turns == 0
 * if X win turns == 1
 * X - O <= 1
 */
import java.util.*;
public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        int [] row = new int [3];
        int [] col = new int [3];
        int diag = 0;
        int anti = 0;
        int turns = 0;
        int xCount = 0;
        int oCount = 0;
        boolean oWin = false;
        boolean xWin = false;
        for(int i = 0; i < board.length; i++) {
            String str = board[i];
            for(int j = 0; j<str.length(); j++) {
                char c = str.charAt(j);
                if(c == 'O') {
                    row[i]--;
                    col[j]--;
                    turns--;
                    if(i == j) {
                        diag--;
                    }
                    if(i + j == 2) {
                        anti--;
                    }
                    oCount++;
                } else if(c == 'X') {
                    row[i]++;
                    col[j]++;
                    turns++;
                    if(i == j) {
                        diag++;
                    }
                    if(i + j == 2) {
                        anti++;
                    }
                    xCount++;
                }
            }
        }
        if(Math.abs(xCount - oCount) > 1) return false;
        if(oCount > xCount) return false;
        if(row[0] == 3 || row[1] == 3 || row[2] == 3 || col[0] == 3 || col[1] == 3 || col[2] == 3 || diag == 3 || anti == 3) {
            xWin = true;
        }
        if(row[0] == -3 || row[1] == -3 || row[2] == -3 || col[0] == -3 || col[1] == -3 || col[2] == -3 || diag == -3 || anti == -3) {
            oWin = true;
        }
        if(xWin && oWin) return false;
        if(xWin && (turns != 1)) return false;
        if(oWin && turns != 0) return false;
        return true;
    }
}
