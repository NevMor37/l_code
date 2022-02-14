import java.util.Arrays;
import java.util.Comparator;

/**
 * There are n cities labeled from 1 to n. You are given the integer n and an array connections where connections[i] = [xi, yi, costi]
 * \indicates that the cost of connecting city xi and city yi (bidirectional connection) is costi.
 *
 * Return the minimum cost to connect all the n cities such that there is at least one path between each pair of cities. If it is impossible to connect all the n cities, return -1,
 *
 * The cost is the sum of the connections' costs used.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
 * Output: 6
 * Explanation: Choosing any 2 edges will connect all cities so we choose the minimum 2.
 * Example 2:
 *
 *
 * Input: n = 4, connections = [[1,2,3],[3,4,4]]
 * Output: -1
 * Explanation: There is no way to connect all cities even if all edges are used.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 * 1 <= connections.length <= 104
 * connections[i].length == 3
 * 1 <= xi, yi <= n
 * xi != yi
 * 0 <= costi <= 105
 */
public class ConnectingCitiesWithMinimumCost {
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
        int [] table = new int [n+1];
        int [] weight = new int [n+1];
        for(int i=1;i<=n; i++) {
            weight[i] = 1;
            table[i] = i;
        }
        int res = 0, edgeCount = 0;
        for(int [] edge : connections) {
            int start = edge[0];
            int end = edge[1];
            int w = edge[2];
            if(find(start, table) == find(end, table)) {
                continue;
            }
            union(start, end, table, weight);
            res += w;
            edgeCount++;
        }
        if(edgeCount != n-1) return -1;
        return res;
    }

    public int find(int a, int [] table) {
        if(a == table[a]) {
            return a;
        }
        return find(table[a], table);
    }
    public void union(int a, int b, int [] table, int [] weight) {
        int rootA = find(a, table);
        int rootB = find(b, table);
        if(rootA == rootB) return;
        if(weight[rootA] >= weight[rootB]) {
            table[rootB] = rootA;
        } else {
            table[rootA] = table[rootB];
        }
    }
}
