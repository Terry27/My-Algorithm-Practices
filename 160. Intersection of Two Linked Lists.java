/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution { //brilliant, a + intersected + 1 + b == b + intersected + 1 + a
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){return null;}
        ListNode itrA = headA, itrB = headB;
        while(itrA != itrB){
            itrA = itrA == null ? headB: itrA.next;
            itrB = itrB == null ? headA: itrB.next;
        }
        return itrA;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){return null;}
        if(headA == headB){return headA;}
        int lenA = 1, lenB = 1;
        ListNode itrA = headA, itrB = headB;
        while(itrA.next != null){
            itrA = itrA.next;
            lenA++;
        }
        while(itrB.next != null){
            itrB = itrB.next;
            lenB++;
        }
        if(itrA != itrB){return null;} //they are not intersecting
        if(lenA < lenB){
            int diff = lenB - lenA;
            while(diff-- > 0){
                headB = headB.next;
            }
        }else{
            int diff = lenA - lenB;
            while(diff-- > 0){
                headA = headA.next;
            }
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}