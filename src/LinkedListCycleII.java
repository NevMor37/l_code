/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle.
 * Note that pos is not passed as a parameter.
 *
 * Do not modify the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * Example 2:
 *
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * Example 3:
 *
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 *
 * Constraints:
 *
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 *
 *
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 *
 * 3 2 0 4
 *
 *  N = D + K + C(i)
 * 2N = D + K + C(j) ->subtract
 * 2D + 2K + 2C(i) = D + K + C(j)
 * D + K + C(2i - j) = 0
 * D + K = (j - 2i)C
 * D = (j-2i)C - K
 * so if one node start from begin and the other from the meeting node they both meet at the looping point
 */
import java.util.*;
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        if(fast == null || fast.next == null) return null;
        //slow == fast for now
        fast = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public ListNode detectCycleOn(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        if(fast == null || fast.next == null) return null;
        //slow == fast for now
        slow = head;
        Set<ListNode> set = new HashSet<>();
        while(true) {
            if(set.add(slow)) {
                slow = slow.next;
            } else
                break;
        }
        return slow;
    }
}
