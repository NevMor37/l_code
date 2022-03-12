/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode copy = dummy;
        while(list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;
            if(val1 > val2) {
                dummy.next = new ListNode(val2);
                list2 = list2.next;
            } else {
                dummy.next = new ListNode(val1);
                list1 = list1.next;
            }
            dummy = dummy.next;
        }
        if(list1 != null) {
            dummy.next = list1;
        } else {
            dummy.next = list2;
        }
        return copy.next;
    }
}
