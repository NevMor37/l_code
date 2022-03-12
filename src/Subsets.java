/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
import com.sun.source.tree.ArrayAccessTree;

import java.util.*;
public class Subsets {
//    List<List<Integer>> res;
//    public List<List<Integer>> subsets(int[] nums) {
//        res = new ArrayList<>();
//        res.add(new ArrayList<>());
//        for(int i = 1; i<=nums.length; i++) {
//            backtrack(i, nums, 0, new ArrayList<>());
//        }
//        return res;
//    }
//
//    public void backtrack(int length, int [] nums, int index, List<Integer> list) {
//        if(list.size() == length) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//
//        for(int i = index; i<nums.length; i++) {
//            list.add(nums[i]);
//            backtrack(length, nums, i + 1, list);
//            list.remove(list.size() -1);
//        }
//    }
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(int []nums, int index, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for(int i = index; i<nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
