/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 *
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place
 * form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *
 *
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 104
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int [] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int [] dfs(TreeNode root) {
        if(root == null) {
            return new int [] {0, 0};
        }
        int val = root.val;
        int[] leftRes = dfs(root.left);
        int[] rightRes = dfs(root.right);
        int [] res = new int [2];
        res[0] = leftRes[1] + rightRes[1] + val;
        res[1] = Math.max(leftRes[0], leftRes[1]) + Math.max(rightRes[0], rightRes[1]);
        return res;
    }
}
