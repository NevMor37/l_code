/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 *
 * You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 *
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
 * plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
 *
 * Return the modified image after performing the flood fill.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel
 * (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 * Example 2:
 *
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
 * Output: [[2,2,2],[2,2,2]]
 *
 *
 * Constraints:
 *
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], newColor < 216
 * 0 <= sr < m
 * 0 <= sc < n
 *
 *  int originColor;
 *     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
 *         originColor = image[sr][sc];
 *         dfs(image, sr, sc, newColor, new boolean[image.length][image[0].length]);
 *         return image;
 *     }
 *     int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
 *     public void dfs(int[][] image, int x, int y, int newColor, boolean [][] visited ) {
 *         image[x][y] = newColor;
 *         visited[x][y] = true;
 *         for(int [] direction : directions) {
 *             int newX = x + direction[0];
 *             int newY = y + direction[1];
 *             if(newX >= 0 && newX < image.length && newY >= 0 && newY < image[0].length && image[newX][newY] == originColor && !visited[newX][newY]) {
 *                 dfs(image, newX, newY, newColor, visited);
 *             }
 *         }
 *         visited[x][y] = true;
 *     }
 */
public class FloodFill {
    int originColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        originColor = image[sr][sc];
        if(newColor != originColor)dfs(image, sr, sc, newColor);
        return image;
    }
    int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void dfs(int[][] image, int x, int y, int newColor) {
        image[x][y] = newColor;

        for(int [] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if(newX >= 0 && newX < image.length && newY >= 0 && newY < image[0].length && image[newX][newY] == originColor) {
                dfs(image, newX, newY, newColor);
            }
        }

    }
}
