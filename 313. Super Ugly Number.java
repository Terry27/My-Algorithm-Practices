public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] index = new int[primes.length];
        ugly[0] = 1;
        for(int i = 1; i < n; i++){
            int curMin = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                curMin = Math.min(ugly[index[j]]*primes[j],curMin);
            }
            ugly[i] = curMin;
            for(int j = 0; j < primes.length; j++){
                if(curMin % primes[j] == 0){
                    index[j]++;
                }
            }
        }
        
        
        return ugly[n-1];
    }
}