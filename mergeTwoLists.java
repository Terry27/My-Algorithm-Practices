/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1== null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode iterator = head;
        ListNode pointer1 = l1, pointer2 = l2;
        while(pointer1 !=null && pointer2 !=null){
            if(pointer1.val < pointer2.val){
                iterator.next = pointer1;
                pointer1 = pointer1.next;
            }else{
                iterator.next = pointer2;
                pointer2 = pointer2.next;
            }
            iterator = iterator.next;
        }
        if(pointer1 !=null){
            iterator.next = pointer1;
        }
        if(pointer2 !=null){
            iterator.next = pointer2;
        }
        return head.next;
    }
}
// public class Solution {
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         if(l1 == null){
//             return l2;
//         }
//         if(l2 == null){
//             return l1;
//         }
        
//         ListNode mergeHead;
//         if(l1.val < l2.val){
//             mergeHead = l1;
//             mergeHead.next = mergeTwoLists(l1.next, l2);
//         }
//         else{
//             mergeHead = l2;
//             mergeHead.next = mergeTwoLists(l1, l2.next);
//         }
//         return mergeHead;
//     }
// }