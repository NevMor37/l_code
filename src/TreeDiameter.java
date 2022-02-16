/**
 * The diameter of a tree is the number of edges in the longest path in that tree.
 *
 * There is an undirected tree of n nodes labeled from 0 to n - 1. You are given a 2D array edges where edges.length == n - 1
 * and edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the tree.
 *
 * Return the diameter of the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: edges = [[0,1],[0,2]]
 * Output: 2
 * Explanation: The longest path of the tree is the path 1 - 0 - 2.
 * Example 2:
 *
 *
 * Input: edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
 * Output: 4
 * Explanation: The longest path of the tree is the path 3 - 2 - 1 - 4 - 5.
 *
 *
 * Constraints:
 *
 * n == edges.length + 1
 * 1 <= n <= 104
 * 0 <= ai, bi < n
 * ai != bi
 */
import java.util.*;
public class TreeDiameter {
    List<List<Integer>> graph;
    int res = 0;
    public int treeDiameter(int[][] edges) {
        buildGraph(edges);
        int n = edges.length + 1;
        dfs(0, new boolean[n]);
        return res;
    }

    public void buildGraph(int [][] edges) {
        this.graph = new ArrayList<>();
        for(int i=0; i<=edges.length; i++) {
            graph.add(new ArrayList<>());
        }
        for(int [] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
    }

    public int dfs(int node, boolean [] visited) {
        visited[node] = true;
        int mostDeep = 0, secondDeep = 0;
        List<Integer> neighbors = this.graph.get(node);
        for(int i = 0; i<neighbors.size(); i++) {
            if(!visited[neighbors.get(i)]) {
                int depth = 1 + dfs(neighbors.get(i), visited);
                if(depth > mostDeep) {
                    secondDeep = mostDeep;
                    mostDeep = depth;
                } else if(depth > secondDeep) {
                    secondDeep = depth;
                }
            }
        }
        this.res = Math.max(res, mostDeep + secondDeep);
        return mostDeep;
    }
    //    public void dfs(int node, int depth, boolean [] visited) {
//        visited[node] = true;
//        List<Integer> neighbors = this.graph.get(node);
//        boolean endNode = true;
//        for(int i=0; i<neighbors.size(); i++) {
//            if(!visited[neighbors.get(i)]) {
//                endNode = false;
//                dfs(neighbors.get(i), depth + 1, visited);
//            }
//        }
//        if(endNode) {
//            res = Math.max(depth, res);
//        }
//    }
}
