/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */
import java.util.*;
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++) map.put(inorder[i], i);
        return construct(preorder, inorder, 0, inorder.length-1, 0);
    }

    public TreeNode construct(int [] preorder, int [] inorder, int inorderStart, int inorderEnd, int preorderStart) {
        if(inorderStart > inorderEnd) return null;
        int cur =  preorder[preorderStart];
        TreeNode root = new TreeNode(cur);
        int inorderPos = map.get(cur);
        int leftSize = inorderPos - inorderStart;
        root.left = construct(preorder, inorder, inorderStart, inorderPos -1, preorderStart + 1);
        root.right = construct(preorder, inorder, inorderPos + 1, inorderEnd, preorderStart + leftSize + 1);
        return root;
    }
}
