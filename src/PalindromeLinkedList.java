/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 *
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode mid = findMid(head);
        ListNode h2 = reverseList(mid);
        while(h2 != null && head != null) {
            if(h2.val != head.val) return false;
            h2 = h2.next;
            head = head.next;
        }
        return h2 == null && head == null;
    }

    ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        if(head == null || head.next == null) return head;
        newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // 1 2 3 4 5
    ListNode findMid(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null) prev.next = null;
        if(fast != null) {
            ListNode temp = slow;
            slow = slow.next;
            temp.next = null;
        }
        return slow;
    }
}
