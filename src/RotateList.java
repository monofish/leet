/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * For example: <br>
 * Given 1->2->3->4->5->NULL and k = 2, <br>
 * return 4->5->1->2->3->NULL.
 *
 * @author Wei
 * @since 2/14/16
 */
public class RotateList {
    /**
     * @param head the List
     * @param k    rotate to the right k places
     * @return the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        return head;
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
