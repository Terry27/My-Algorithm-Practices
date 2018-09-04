/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pQueue = new PriorityQueue<>((a,b)-> a.val-b.val);
        for(ListNode l: lists){
            if(l != null){
                pQueue.offer(l);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!pQueue.isEmpty()){
            ListNode min = pQueue.poll();
            cur.next = min;
            cur = cur.next;
            if(min.next != null){
                pQueue.offer(min.next);
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
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        return mergeKLists(lists, 0, lists.length-1);
    }
    
    public ListNode mergeKLists(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }else if(start < end){
            int mid = start + (end-start)/2;
            ListNode left = mergeKLists(lists, start, mid);
            ListNode right = mergeKLists(lists, mid+1,end);
            return mergeTwoLists(left, right);
        }
        return null;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null || l2 == null){
            return l1 == null? l2:l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null || l2  != null){
            int curL1 = (l1 == null) ? Integer.MAX_VALUE: l1.val;
            int curL2 = (l2 == null) ? Integer.MAX_VALUE: l2.val;
            if(curL1 < curL2){
                cur.next = l1;
                if(l1 != null){
                    l1 = l1.next;
                }
            }else{
                cur.next = l2;
                if(l2 != null){
                    l2 = l2.next;
                }
            }
            cur = cur.next;
        }
        
        return dummy.next;
    }
}