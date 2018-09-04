class Solution {
    public int hammingDistance(int x, int y) {
        int diff = x ^ y;
        int count = 0;
        while(diff > 0){
            //count++;
            //1. diff = diff - (diff & (-diff));
            //2. diff = diff & (diff-1);
            
            //3.
            count += diff & 1;
            diff = diff >>> 1; //which shift doesn't matter
            //The unsigned right shift operator ">>>" shifts a zero into the leftmost position, 
            //while the leftmost position after ">>" depends on sign extension.
        }
        return count;
    }
}