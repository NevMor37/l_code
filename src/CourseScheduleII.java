/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where
 * prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is
 * impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2
 * should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 */
import java.util.*;
public class CourseScheduleII {
    List<List<Integer>> graph;
    Map<Integer, Integer> map;
    List<Integer> reverseRes;
    boolean doable = true;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<>();
        map = new HashMap<>();
        reverseRes = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            map.put(i, 1);
            graph.add(new ArrayList<>());
        }
        for(int [] pre : prerequisites) {
            int start = pre[1];
            int end = pre[0];
            graph.get(start).add(end);
        }
        for(int i=0; i<numCourses; i++) {
            if(map.get(i) == 1) {
                dfs(i);
            }
        }
        if(doable) {
            Collections.reverse(reverseRes);
            return reverseRes.stream().mapToInt(a -> a).toArray();
        }
        return new int[0];
    }

    public void dfs(int node) {
        map.put(node, 2);
        List<Integer> neighbors = graph.get(node);
        for(int i = 0; i<neighbors.size(); i++) {
            int next = neighbors.get(i);
            if(map.get(next) == 2) {
                this.doable = false;
                return;
            } else if(map.get(next) == 1) {
                dfs(next);
            }
        }
        reverseRes.add(node);
        map.put(node, 3);
    }
}
