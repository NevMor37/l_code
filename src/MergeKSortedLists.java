import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 */
public class MergeKSortedLists {
    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        ListNode res = new ListNode(0);
        if(lists == null || lists.length == 0) return res.next;
        ListNode temp = res;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(int i=0; i<lists.length; i++) {
            if(lists[i] != null) pq.offer(lists[i]);
        }
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            if(node.next != null) pq.offer(node.next);
            res.next = node;
            res = res.next;
        }
        return temp.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        return sort(lists, 0, lists.length-1);
    }

    public ListNode sort(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }
        int mid = start + (end - start)/2;
        ListNode left = sort(lists, start, mid);
        ListNode right = sort(lists, mid +1, end);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(left != null && right != null) {
            int val1 = left.val;
            int val2 = right.val;
            if(val1 < val2) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        tail.next = left == null ? right : left;
        return dummy.next;
    }
}
