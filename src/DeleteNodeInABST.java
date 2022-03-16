/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,7], key = 0
 * Output: [5,3,6,2,4,null,7]
 * Explanation: The tree does not contain a node with value = 0.
 * Example 3:
 *
 * Input: root = [], key = 0
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -105 <= Node.val <= 105
 * Each node has a unique value.
 * root is a valid binary search tree.
 * -105 <= key <= 105
 *
 *
 * Follow up: Could you solve it with time complexity O(height of tree)?
 *
 * public TreeNode deleteNode(TreeNode root, int key) {
 *         if(root == null) return null;
 *         if(root.val < key) {
 *             deleteNode(root.right, key);
 *         } else if(root.val > key) {
 *             deleteNode(root.left, key);
 *         } else {
 *             if(root.left == null && root.right==null) {
 *                 root = null;
 *             }else if(root.right != null) {
 *                 root.val = findSuccessor(root);
 *                 deleteNode(root.right, root.val);
 *             } else if(root.left != null) {
 *                 root.val= findPre(root.left);
 *                 deleteNode(root.left, root.val);
 *             }
 *         }
 *         return root;
 *     }
 *
 *     public int findSuccessor(TreeNode root) {
 *         root = root.right;
 *         while(root.left != null) {
 *             root = root.left;
 *         }
 *         return root.val;
 *     }
 *
 *     public int findPre(TreeNode root) {
 *         root = root.left;
 *         while(root.right != null) {
 *             root = root.right;
 *         }
 *         return root.val;
 *     }
 *
 *     public TreeNode deleteNode(TreeNode root, int key) {
 *         if(root == null) return root;
 *         if(root.val < key) {
 *             root.right = deleteNode(root.right, key);
 *         } else if(root.val > key) {
 *             root.left = deleteNode(root.left, key);
 *         } else {
 *             if(root.left == null && root.right == null) {
 *                 root = null;
 *             } else if(root.left == null) {
 *                 root = root.right;
 *             } else if(root.right == null) {
 *                 root = root.left;
 *             } else {
 *                 TreeNode replace = findNext(root);
 *                 root.val = replace.val;
 *                 root.right = deleteNode(root.right, root.val);
 *             }
 *         }
 *
 *         return root;
 *     }
 *
 *     public TreeNode findNext(TreeNode root) {
 *         root = root.right;
 *         while(root.left != null) {
 *             root = root.left;
 *         }
 *         return root;
 *     }
 *
 *     public TreeNode deleteNode(TreeNode root, int key) {
 *         if(root == null) return null;
 *         if(root.val > key) {
 *             root.left = deleteNode(root.left, key);
 *         } else if(root.val < key) {
 *             root.right = deleteNode(root.right, key);
 *         } else {
 *             if(root.left == null && root.right == null) {
 *                 return null;
 *             }
 *             if(root.left == null) {
 *                 return root.right;
 *             }
 *             if(root.right == null) {
 *                 return root.left;
 *             }
 *             int minimumMax = findMinimumMax(root);
 *             root.val = minimumMax;
 *             root.right = deleteNode(root.right, minimumMax);
 *         }
 *         return root;
 *     }
 *
 *     public int findMinimumMax(TreeNode node) {
 *         node = node.right;
 *         while(node.left != null) {
 *             node = node.left;
 *         }
 *         return node.val;
 *     }
 *
 */
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            int val = findMin(root);
            root.val = val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    public int findMin(TreeNode root) {
       root = root.right;
       while(root.left != null) {
           root = root.left;
       }
       return root.val;
    }
}
