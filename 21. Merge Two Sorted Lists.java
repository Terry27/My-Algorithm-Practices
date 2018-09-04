/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution { // iteration
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode trav = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                trav.next = l1;
                l1 = l1.next;
            }else{
                trav.next = l2;
                l2 = l2.next;
            }
            trav = trav.next;
        }
        trav.next = l1 != null ? l1: l2;
        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution { //recursion optimized
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode dummy;
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

class Solution { //recursion
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode dummy;
        if(l1.val <= l2.val){
            dummy = l1;
            dummy.next = mergeTwoLists(l1.next, l2);
        }else{
            dummy = l2;
            dummy.next = mergeTwoLists(l1, l2.next);
        }
        return dummy;
    }
}