public class Solution {   //WITH EXTRA ARRAY. can be reduced to 3 variables
    public int numWays(int n, int k) { 
        if(n<=0){
            return 0;
        }else if(n==1){
            return k;
        }else if(n ==2){
            return k*k;
        }
        int[] table = new int[n+1];
        table[0] = 0;
        table[1] = k;
        table[2] = k*k;
        for(int i=3;i<=n;i++){
            table[i] = (table[i-1]+table[i-2])*(k-1);
        }
        return table[n];
    }
}

