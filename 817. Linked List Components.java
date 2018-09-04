/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for(int g: G){
            set.add(g);
        }
        int comp = 0;
        ListNode tmp = head;
        boolean prev = false;
        while(tmp != null){
            if(set.contains(tmp.val)){
                if(!prev){
                    prev = true;
                    comp++;
                }
            }else{
                prev = false;
            }
            tmp = tmp.next;
        }
        return comp;
    }
}