/**
 * Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST. If the given node has no in-order successor in the tree, return null.
 *
 * The successor of a node p is the node with the smallest key greater than p.val.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3], p = 1
 * Output: 2
 * Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], p = 6
 * Output: null
 * Explanation: There is no in-order successor of the current node, so the answer is null.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 * All Nodes will have unique values.
 */
public class InorderSuccessorInBST {
    TreeNode prev;
    TreeNode inorderSuccessor;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right != null) {
            p = p.right;
            while(p.left != null) {
                p = p.left;
            }
            return p;
        }
        inorder(root, p);
        return inorderSuccessor;
    }
    public void inorder(TreeNode root, TreeNode p) {
        if(root == null) return;
        inorder(root.left, p);
        if(prev == p && inorderSuccessor == null) {
            inorderSuccessor = root;
            return;
        }
        prev = root;
        inorder(root.right, p);
    }

    public TreeNode inorderSuccessorBest(TreeNode root, TreeNode p) {
        if(p.right != null) {
            p = p.right;
            while(p.left != null) {
                p = p.left;
            }
            return p;
        }
        TreeNode node = root;
        TreeNode prev = null;
        while(node != null) {
            if(node.val > p.val) {
                prev = node;
                node = node.left;
            } else if(node.val < p.val){
                node = node.right;
            } else {
                return prev;
            }
        }
        return null;
    }
}
