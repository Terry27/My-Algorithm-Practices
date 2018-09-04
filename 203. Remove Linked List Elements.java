/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy, fast = head;
        while(fast != null){
            while(fast != null && fast.val == val){
                fast = fast.next;
            }
            slow.next = fast;
            if(fast == null){
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return dummy.next;
    }
}
