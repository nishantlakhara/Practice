package leetcode.linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;

        while (cur != null) {
            //Reverse the pointer in current node.
            cur.next = prev;

            prev = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }
        }

        return prev;
    }

}
