/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
import java.util.*;
public class CombinationSumII {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }

    public void backtrack(int [] candidates, int target, int cur, List<Integer> list, int index) {
        if(cur > target) return;
        if(cur == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i<candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1] ) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(candidates, target, cur + candidates[i], list, i + 1);
            list.remove(list.size()-1);
        }
    }
}
