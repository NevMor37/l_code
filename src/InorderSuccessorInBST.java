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
    TreeNode target;
    TreeNode pre;
    TreeNode res = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //case 1: smallest node of the right subtree
        if(p.right != null) {
            p = p.right;
            while(p.left != null) {
                p = p.left;
            }
            return p;
        }
        this.target = p;
        //case2
        inorder(root);
        return res;
    }

    public void inorder(TreeNode node) {
        if(node == null) return;
        inorder(node.left);
        if(this.target == this.pre && this.res == null) {
            this.res = node;
            return;
        }
        this.pre = node;
        inorder(node.right);
    }

    public TreeNode inorderSuccessorBST(TreeNode root, TreeNode p) {
        TreeNode prev = null;
        while(root != null) {
            if(p.val >= root.val) {
                root = root.right;
            } else {
                //go back from right, parent already visited
                //keep going back until go up from left
                prev = root;
                root = root.left;
            }
        }
        return prev;
    }
}
