/**
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 *
 *
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        int len = 0;
        while(fast != null) {
            len++;
            fast = fast.next;
        }
        k = k%len;
        if(k == 0) return head;
        fast = head;
        while(k > 0) {
            fast = fast.next;
            k--;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
