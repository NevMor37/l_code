/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with
 * different approaches yourself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 *
 *  String s = "";
 *     // Encodes a tree to a single string.
 *     public String serialize(TreeNode root) {
 *         if(root == null) return s;
 *         s+=root.val;
 *         preOrder(root.left);
 *         preOrder(root.right);
 *         System.out.println(s);
 *         return s;
 *     }
 *
 *     public void preOrder(TreeNode root) {
 *         if(root == null) {
 *             s+=",null";
 *             return;
 *         }
 *         s+="," + root.val;
 *         preOrder(root.left);
 *         preOrder(root.right);
 *     }
 *     //
 *     // Decodes your encoded data to tree.
 *     public TreeNode deserialize(String data) {
 *         if(data == null || data.length() == 0) return null;
 *         String [] strs = data.split(",");
 *         List<String> datas = new ArrayList<>();
 *         for(String str : strs) {
 *             datas.add(str);
 *         }
 *         for(String str : datas) {
 *             System.out.println(str);
 *         }
 *         return deserialize(datas);
 *     }
 *
 *     public TreeNode deserialize(List<String> datas) {
 *         if(datas.size() == 0) {
 *             return null;
 *         }
 *         if(datas.get(0).equals("null")) {
 *             datas.remove(0);
 *             return null;
 *         }
 *         int val = Integer.valueOf(datas.get(0));
 *         datas.remove(0);
 *         TreeNode node = new TreeNode(val);
 *         node.left = deserialize(datas);
 *         node.right = deserialize(datas);
 *         return node;
 *     }
 */
import java.util.*;
public class SerializeAndDeserializeBinaryTree {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder serializedString = new StringBuilder();
            inorder(root, serializedString);
            return serializedString.toString();
        }

        private void inorder(TreeNode root, StringBuilder sb) {
            if(root == null) {
                sb.append("null,");
                return;
            }
            sb.append(root.val + ",");
            inorder(root.left, sb);
            inorder(root.right, sb);

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String [] nodes = data.split(",");
            List<String> list = new ArrayList<>(Arrays.asList(nodes));
            return reverseInorder(list);
        }

        private TreeNode reverseInorder(List<String> nodes) {
            if(nodes == null || nodes.size() == 0) return null;
            if(nodes.get(0).equals("null")) {
                nodes.remove(0);
                return null;
            }
            int val = Integer.parseInt(nodes.get(0));
            TreeNode node = new TreeNode(val);
            nodes.remove(0);
            node.left = reverseInorder(nodes);
            node.right = reverseInorder(nodes);
            return node;
        }
    }
    public static void main(String [] args) {
        String test = "1,2,3,4,";
        String [] splits = test.split(",");
        System.out.println(splits.length);
        for(String i : splits) System.out.printf("%s ",i);
    }
}
