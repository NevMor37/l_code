/**
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 * 1 2->null null<-3<-4<-5 6 7
 * Follow up: Could you do it in one pass?
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        ListNode prev = null, cur = head;
        while(cur != null && left>1) {
            prev = cur;
            cur = cur.next;
            left--;
            right--;
        }
        ListNode reversePrev = null;
        ListNode cut = cur;
        while(right>0) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = reversePrev;
            reversePrev = temp;
            right--;
        }
        if(prev != null) {
            prev.next = reversePrev;
        } else {
            head = reversePrev;
        }
        cut.next = cur;
        return head;
    }
}
