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
    public void reorderList(ListNode head) {

     ListNode slow=head;
     ListNode fast = head.next;


     while(fast!=null && fast.next!=null)
     {
        slow=slow.next;
        fast=fast.next.next;
     }

     ListNode current = slow.next;

     ListNode prev = reverse(current);

     slow.next=null;

     ListNode first = head;
     ListNode second = prev;

     while(second!=null)
     {
        ListNode t1= first.next;
        ListNode t2 =second.next;
        first.next=second;
        second.next=t1;

        first=t1;
        second=t2;

     }

    }

    private ListNode reverse(ListNode curr)
    {
        ListNode prev=null;
        ListNode current = curr;

        while(current!=null)
        {
            ListNode next = current.next;
            current.next=prev;
            prev=current;
            current = next;
        }

        return prev;
    }
}
