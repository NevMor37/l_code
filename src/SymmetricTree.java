/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Could you solve it both recursively and iteratively?
 */
import java.util.*;
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode node1, TreeNode node2) {
        if(node1== null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val !=  node2.val) return false;
        return dfs(node1.left, node2.right) && dfs(node1.right, node2.left);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i<size; i+=2) {
                TreeNode node1 = queue.poll();
                TreeNode node2 = queue.poll();
                if(node1 == null && node2 == null) continue;
                if(node1 == null || node2 == null) return false;
                if(node1.val != node2.val) return false;
                queue.offer(node1.left);
                queue.offer(node2.right);
                queue.offer(node1.right);
                queue.offer(node2.left);
            }
        }
        return true;
    }
}
