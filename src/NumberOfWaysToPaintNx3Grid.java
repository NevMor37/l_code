/**
 * You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colors:
 * Red, Yellow, or Green while making sure that no two adjacent cells have the same color (i.e., no two cells that share vertical or horizontal sides have the same color).
 *
 * Given n the number of rows of the grid, return the number of ways you can paint this grid. As the answer may grow large, the answer must be computed modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 1
 * Output: 12
 * Explanation: There are 12 possible way to paint the grid as shown.
 * Example 2:
 *
 * Input: n = 5000
 * Output: 30228214
 *
 *
 * Constraints:
 *
 * n == grid.length
 * 1 <= n <= 5000
 *
 * 123 132 213 231 312 321
 * 121 323 212 313 232 131
 *
 * 121 232 212 313 312 213
 * 123 312 231 232 212
 */
public class NumberOfWaysToPaintNx3Grid {
    public int numOfWays(int n) {
        long [] towColor = new long [n + 1];
        long [] threeColor = new long [n + 1];
        towColor[1] = 6;
        threeColor[1] = 6;
        int mod = (int)(1e9 + 7);
        for(int i = 2; i<=n ;i++) {
            threeColor[i] = (towColor[i-1] * 2 + threeColor[i-1] * 2)%mod;
            towColor[i] = (towColor[i -1] * 3 + threeColor[i-1] * 2)%mod;
        }
        return (int)(threeColor[n] + towColor[n])%mod;
    }
}
