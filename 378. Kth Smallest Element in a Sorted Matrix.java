// Sol1: same as Leetcode373 Find K Pairs with Smallest Sums
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[2]-b[2];
            }
        });
        for(int i = 0; i < matrix.length; i++){
            pQueue.offer(new int[]{i,0,matrix[i][0]});
        }
        int count = 0;
        int res = 0;
        while(count < k-1){
            int[] cur = pQueue.poll();
            if(cur[1] < matrix[0].length-1){
                pQueue.offer(new int[]{cur[0], cur[1]+1, matrix[cur[0]][cur[1]+1]});
            }
            count++;
        }
        
        return pQueue.poll()[2];
    }
}

//Sol2: bianry search