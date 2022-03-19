/**
 * Given the root of a binary search tree, a target value, and an integer k, return the k values in the BST
 * that are closest to the target. You may return the answer in any order.
 *
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,5,1,3], target = 3.714286, k = 2
 * Output: [4,3]
 * Example 2:
 *
 * Input: root = [1], target = 0.000000, k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104.
 * 0 <= Node.val <= 109
 * -109 <= target <= 109
 *
 *
 * Follow up: Assume that the BST is balanced. Could you solve it in less than O(n) runtime (where n = total nodes)?
 *
 * two stack for O(n) solution
 * one sort in small -> big < target one sort in big -> small > target
 * pop from both and get k
 */
import java.util.*;
public class ClosestBinarySearchTreeValueII {
    PriorityQueue<Integer> pq;
    int k;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        this.k = k;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double a = (double) o1;
                double b = (double) o2;
                return Math.abs(b - target) - Math.abs(a - target) > 0 ? 1 : -1;
            }
        };
        pq = new PriorityQueue<>(comparator);
        inorder(root);
        for(int i : pq) {
            res.add(i);
        }
        return res;
    }

    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        pq.add(root.val);
        if(pq.size() > k) {
            pq.poll();
        }
        inorder(root.right);
    }

    public static void main(String [] args) {
        int a = 3,b = 8;
        System.out.println(Math.abs((double)a - 5.285714));
        System.out.println(Math.abs((double)b - 5.285714));
    }
}
