/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution { //recursive
    public ListNode reverseList(ListNode head) {
        if(head == null){return null;}
        if(head.next == null){return head;}
        ListNode newRoot = reverseList(head.next);
        head.next.next = head;
        head.next = null; //must do
        return newRoot;
        
    }
}

class Solution { //iterative
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}

