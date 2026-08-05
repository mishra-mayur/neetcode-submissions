/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        //base condition
        if(head == null)
            return null;

        int size = 0;
        ListNode temp = head;

        while(temp != null) {
            temp = temp.next;
            size++;
        }

        int remove = size - n + 1;

        if(remove == 1) {
            head = head.next;
            return head;
        }

        temp = head;
        int count = 1;

        while(count != remove - 1) {
            temp = temp.next;
            count++;
        }
        ListNode next = temp.next;
        temp.next = next.next;
        return head;

    }
}
