/**
 * In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
 *
 * A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 *
 *
 * Return the minimum number of steps needed to move the knight to the square [x, y]. It is guaranteed the answer exists.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 2, y = 1
 * Output: 1
 * Explanation: [0, 0] → [2, 1]
 * Example 2:
 *
 * Input: x = 5, y = 5
 * Output: 4
 * Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 *
 *
 * Constraints:
 *
 * -300 <= x, y <= 300
 * 0 <= |x| + |y| <= 300
 */
import java.util.*;
public class MinimumKnightMoves {
    int [][] directions = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};
    public int minKnightMoves(int x, int y) {
        Queue<int []> queue = new LinkedList<>();
        // visited store, we move each x and y an offset of 302 so we can store the negative value
        boolean [][] visited = new boolean [610][610];
        queue.offer(new int [] {0, 0});
        visited[302][302] = true;
        int res = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                int [] cur = queue.poll();
                if(cur[0] == x && cur[1] == y) {
                    return res;
                }
                for(int [] direction : directions) {
                    int newX = cur[0] + direction[0];
                    int newY = cur[1] + direction[1];
                    if(!visited[newX + 302][newY + 302]) {
                        queue.offer(new int [] {newX, newY});
                        visited[newX + 302][newY + 302] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
