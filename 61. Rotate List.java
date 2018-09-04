public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
           return head; 
        }
        // count length, get mod
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        
        ListNode tmp = newHead;
        int length = 0;
        while(tmp.next != null){
            tmp = tmp.next;
            length++;
        }
        // now tmp is the end node
        
        int rotate = k % length;
        rotate = length - rotate; 
        
        ListNode traverse = newHead;
        for (int i = 0; i < rotate; i++){
            traverse = traverse.next;
        }
        // split and put right part to the start of the list
        tmp.next = head;
        newHead.next = traverse.next;
        traverse.next = null;
        return newHead.next;
    }
}