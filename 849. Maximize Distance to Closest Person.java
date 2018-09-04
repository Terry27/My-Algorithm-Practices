class Solution {
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int i = 0;
        int j = 0;
        while(j < seats.length){
            while(j < seats.length && seats[j] == 1){j++;}
            i = j; //start of 0s
            while(j < seats.length && seats[j] == 0){j++;}
            if(i == 0 || j == seats.length){
                max = Math.max(max, j - i);
            }else{
                max = Math.max(max, (j - i + 1)/2);
            }
        }
        return max;
    }
}