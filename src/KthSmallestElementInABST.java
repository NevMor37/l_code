/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 */
import java.util.*;
public class KthSmallestElementInABST {
    public int kthSmallestOn(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(true) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()) {
                TreeNode next = stack.pop();
                list.add(next.val);
                if(next.right != null) {
                    root = next.right;
                }
            } else {
                break;
            }
        }
        return list.get(k-1);
    }
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(true) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()) {
                TreeNode next = stack.pop();
                if(k == 1) return next.val;
                k--;
                if(next.right != null) {
                    root = next.right;
                }
            } else {
                break;
            }
        }
        return -1;
    }
}
