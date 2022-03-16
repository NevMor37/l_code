/**
 * Given an array of unique integers preorder, return true if it is the correct preorder traversal sequence of a binary search tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: preorder = [5,2,1,3,6]
 * Output: true
 * Example 2:
 *
 * Input: preorder = [5,2,6,1,3]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 104
 * 1 <= preorder[i] <= 104
 * All the elements of preorder are unique.
 *
 *
 * Follow up: Could you do it using only constant space complexity?
 */
// 4 2 6 5 3 7 8

//当进来一个数字 比较大 我们要做的就是pop stack 来找到这个树（其实是某一个右子树）的父节点 并且 因为是preorder
// 大 -》 小-》大
//以后的每一个数都应该比这个右子树的父节点大
import java.util.*;
public class VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder.length == 1) return true;
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for(int val : preorder) {
            if(val < min) return false;
            while(!stack.isEmpty() && stack.peek() < val) {
                min = stack.pop();
            }
            stack.push(val);
        }
        return true;
    }
}
