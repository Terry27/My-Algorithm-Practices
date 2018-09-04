public class Solution {
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(nums1 == null || nums1.length == 0|| nums2 == null || nums2.length == 0 || k <=0){
            return res;
        }
        if(k > nums1.length*nums2.length){
            k = nums1.length*nums2.length;
        }
        Queue<int[]> pQueue = new PriorityQueue<>(k,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[2]-b[2];
            }
        });
        int cur = 0;
        for(int i = 0; i< nums1.length; i++){
            pQueue.add(new int[]{i,0,nums1[i]+nums2[0]});
        }
        // merge k sorted list approach,
        /*
           0 1 2
        0  ~
        1  ~
        2  ~
        put (0,0),(1,0),(2,0) into PQ first, then poll and offer new element to the right of the polled element 
        */
        while(cur < k){
            int[] curS = pQueue.poll();
            res.add(new int[]{nums1[curS[0]],nums2[curS[1]]});
            if(curS[1]<nums2.length-1){
                pQueue.offer(new int[]{curS[0],curS[1]+1,nums1[curS[0]]+nums2[curS[1]+1]});
            }
            cur++;
        }
        
        return res;
        
    }
}