/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pQueue = new PriorityQueue<>((o1,o2)->o1.val-o2.val);
        ListNode dummy = new ListNode(0);
        ListNode trav = dummy;
        for(ListNode l: lists){
            if(l != null){
                pQueue.offer(l);
            }
        }
        while(!pQueue.isEmpty()){
            ListNode cur = pQueue.poll();
            trav.next = cur;
            trav = trav.next;
            if(cur.next != null){
                pQueue.offer(cur.next);
            }
        }
        return dummy.next;

    }
}


//merge sort approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length-1);
    }

    public ListNode mergeKLists(ListNode[] lists, int startIndex, int endIndex){
        if(startIndex == endIndex){
            return lists[startIndex];
        }
        if(startIndex < endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            ListNode l1 = mergeKLists(lists, startIndex, midIndex);
            ListNode l2 = mergeKLists(lists, midIndex + 1, endIndex);
            return merge2Lists(l1,l2);
        }
        return null;


    }

    public ListNode merge2Lists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val <= l2.val){
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        }else{
            l2.next = merge2Lists(l1, l2.next);
            return l2;
        }
    }


}
