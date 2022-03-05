/**
 * You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 *
 * The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 *
 *
 *
 * Example 1:
 *
 *
 * Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Example 2:
 *
 * Input: firstList = [[1,3],[5,9]], secondList = []
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= firstList.length, secondList.length <= 1000
 * firstList.length + secondList.length >= 1
 * 0 <= starti < endi <= 109
 * endi < starti+1
 * 0 <= startj < endj <= 109
 * endj < startj+1
 */
import java.util.*;
public class IntervalListInterSections {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int []> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < firstList.length && j < secondList.length) {
            int [] i1 = firstList[i];
            int [] i2 = secondList[j];
            if(i1[0] >= i2[0]) {
                if(i2[1] >= i1[0]) {
                    list.add(new int [] {i1[0], Math.min(i1[1], i2[1])});
                }
            } else {
                if(i1[1] >= i2[0]) {
                    list.add(new int [] {i2[0], Math.min(i1[1], i2[1])});
                }
            }
            if(i1[1] > i2[1]) {
                j++;
            } else {
                i++;
            }
        }
        int [][] res = new int [list.size()][2];
        i=0;
        for(int [] k : list) {
            res[i++] = k;
        }
        return res;
    }

    public int[][] intervalIntersectionGood(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;
        while(i < firstList.length && j < secondList.length) {
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if(lo <= hi)
            ans.add(new int [] {lo, hi});
            if(firstList[i][1] > secondList[j][1]) {
                j++;
            } else {
                i++;
            }
        }
        return ans.toArray(new int [ans.size()][2]);
    }

    public static void main(String [] args) {
        int [][] list1 = {{0,2}, {5, 10}, {13, 23}, {24, 25}};
        int [][] list2 = {{1,5}, {8, 12}, {15, 24}, {25, 26}};
        intervalIntersection(list1, list2);
    }
}
