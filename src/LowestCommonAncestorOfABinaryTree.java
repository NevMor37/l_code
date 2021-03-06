/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p
 * and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 *
 *  TreeNode ret;
 *     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
 *         dfs(root, p, q);
 *         return ret;
 *     }
 *
 *     public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
 *         if(root == null) return false;
 *         int res = 0;
 *         if(root.val == p.val || root.val == q.val) res++;
 *         int left = dfs(root.left, p, q) ? 1 : 0;
 *         int right = dfs(root.right, p, q) ? 1 : 0;
 *         res += left + right;
 *         if(res > 1 && ret == null) ret = root;
 *         return res > 0;
 *     }
 */
public class LowestCommonAncestorOfABinaryTree {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;
        int val = 0;
        if(root.val == p.val || root.val == q.val) {
            val++;
        }
        if(dfs(root.left, p, q)) val++;
        if(dfs(root.right, p, q)) val++;
        if(val >= 2 && res == null) {
            res = root;
        }
        return val >= 1;
    }
}
