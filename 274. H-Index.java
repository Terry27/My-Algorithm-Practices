class Solution {
    public int hIndex(int[] citations) {
        // A scientist has index h if h of his/her N papers have at least h citations each
        int[] buckets = new int[citations.length+1];
        for(int num: citations){
            if(num >= buckets.length){
                buckets[buckets.length-1]++;
            }else{
                buckets[num]++;
            }
        }
        int count = 0;
        //from right to left, when count >= curIndex, this is the H-index
        for(int i = buckets.length - 1; i >=0; i--){
            count += buckets[i];
            if(count >= i){
                return i;
            }
        }
        return 0;
    }
}