class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        for(int i = 1; i < n; i++){
            int curMin = Math.min(Math.min(ugly[idx2]*2, ugly[idx3]*3), ugly[idx5]*5);
            ugly[i] = curMin;
            if(curMin == ugly[idx2]*2){idx2++;}
            if(curMin == ugly[idx3]*3){idx3++;}
            if(curMin == ugly[idx5]*5){idx5++;}
            
        }
        
        return ugly[n-1];
    }
}