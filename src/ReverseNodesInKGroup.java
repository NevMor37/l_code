import java.util.List;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 *
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 */
public class ReverseNodesInKGroup {
    //count if we have enough nodes for k
    //if not just return head;
    //if yes, we reverse the next k nodes from head, return the newhead, put the tail.next into recursive call
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int count = 0;
        ListNode cur = head;
        while(cur != null && count <k) {
            cur = cur.next;
            count++;
        }
        if(count == k) {
            ListNode newHead = reverseLinkedList(head, k);
            head.next = reverseKGroup(cur, k);
            return newHead;
        }
        return head;
    }

    public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode prev = null, cur = head;
        while(k >0) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = prev;
            prev = temp;
            k--;
        }
        return prev;
    }
}
