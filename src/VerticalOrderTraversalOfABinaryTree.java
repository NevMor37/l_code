/**
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
 *
 * For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively.
 * The root of the tree is at (0, 0).
 *
 * The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost
 * column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
 *
 * Return the vertical order traversal of the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Column -1: Only node 9 is in this column.
 * Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
 * Column 1: Only node 20 is in this column.
 * Column 2: Only node 7 is in this column.
 * Example 2:
 *
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * Column -2: Only node 4 is in this column.
 * Column -1: Only node 2 is in this column.
 * Column 0: Nodes 1, 5, and 6 are in this column.
 *           1 is at the top, so it comes first.
 *           5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
 * Column 1: Only node 3 is in this column.
 * Column 2: Only node 7 is in this column.
 * Example 3:
 *
 *
 * Input: root = [1,2,3,4,6,5,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * This case is the exact same as example 2, but with nodes 5 and 6 swapped.
 * Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 1000
 */
import java.sql.Array;
import java.util.*;
public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeWrapper> tempList = new ArrayList<>();
        Queue<NodeWrapper> queue = new LinkedList<>();
        queue.offer(new NodeWrapper(0, root, 0));
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                NodeWrapper nodeWrapper = queue.poll();
                int currentCol = nodeWrapper.col;
                TreeNode currentNode = nodeWrapper.node;
                int currentRow = nodeWrapper.row;
                if(currentNode.left != null) {
                    queue.offer(new NodeWrapper(currentCol -1, currentNode.left, currentRow+1));
                }
                if(currentNode.right != null) {
                    queue.offer(new NodeWrapper(currentCol +1, currentNode.right, currentRow+1));
                }
                tempList.add(nodeWrapper);
            }
        }
        tempList.sort((a, b) -> a.col - b.col == 0 ? (a.row - b.row == 0 ? a.node.val - b.node.val : a.row-b.row) : a.col - b.col);
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int col = tempList.get(0).col;
        for(NodeWrapper nodeWrapper : tempList) {
            if(nodeWrapper.col == col) {
                temp.add(nodeWrapper.node.val);
            } else {
                col = nodeWrapper.col;
                res.add(temp);
                temp = new ArrayList<>();
                temp.add(nodeWrapper.node.val);
            }
        }
        res.add(temp);
        return res;
    }

    class NodeWrapper {
        int col;
        int row;
        TreeNode node;

        public NodeWrapper(int col, TreeNode node, int row) {
            this.col = col;
            this.node = node;
            this.row = row;
        }

        public NodeWrapper() {
        }
    }
}
