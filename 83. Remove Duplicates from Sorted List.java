/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){return head;}
        ListNode itr = head;
        while(itr.next != null){
            if(itr.next.val == itr.val){ //loop until next val is different
                itr.next = itr.next.next;
            }else{
                itr = itr.next;
            }
            
        }
        return head;
    }
}