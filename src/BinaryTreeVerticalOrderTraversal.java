/**
 * Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Example 2:
 *
 *
 * Input: root = [3,9,8,4,0,1,7]
 * Output: [[4],[9],[3,0,1],[8],[7]]
 * Example 3:
 *
 *
 * Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
 * Output: [[4],[9,5],[3,0,1],[8,2],[7]]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<NodeWrapper>  queue = new LinkedList<>();
        queue.offer(new NodeWrapper(0, root));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                NodeWrapper nodeWrapper = queue.poll();
                TreeNode node = nodeWrapper.node;
                int l = nodeWrapper.layer;
                if(!map.containsKey(l)) {
                    List<Integer> list = new ArrayList<>();
                    map.put(l, list);
                }
                map.get(l).add(node.val);
                if(node.left != null) {
                    queue.offer(new NodeWrapper(l-1, node.left));
                }
                if(node.right != null) {
                    queue.offer(new NodeWrapper(l+1, node.right));
                }
            }
        }
        return map.values().stream().collect(Collectors.toList());
    }

    class NodeWrapper {
        int layer;
        TreeNode node;

        public NodeWrapper(int layer, TreeNode node) {
            this.layer = layer;
            this.node = node;
        }
    }
}
