/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 * Example 2:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [8,0,7]
 * Example 3:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 *
 *
 * Follow up: Could you solve it without reversing the input lists?
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rL1 = reverseListIterative(l1);
        ListNode rL2 = reverseListIterative(l2);
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        int inc = 0;
        while(rL1 != null || rL2 != null) {
            int val1 = rL1 == null ? 0 : rL1.val;
            int val2 = rL2 == null ? 0 : rL2.val;
            int temp = val1 + val2 + inc;
            inc = temp/10;
            temp = temp%10;
            dummy.next = new ListNode(temp);
            dummy = dummy.next;
            rL1 = rL1 == null ? null : rL1.next;
            rL2 = rL2 == null ? null : rL2.next;
        }
        if(inc != 0) {
            dummy.next = new ListNode(1);
        }
        ListNode temp = res;
        res = res.next;
        temp.next = null;
        return reverseList(res);
    }

    public ListNode reverseList(ListNode head) {
        if(head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }
}
