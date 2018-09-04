public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0){
            return 0;
        }
        int len = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return a[1]-b[1];
                }
                return a[0]-b[0];
            }
        });
        
        int[] dp = new int[len];
        for(int i = 0; i< len; i++){
            dp[i] = 1;
        }
        for(int i = 1; i < len; i++){
            for( int j = 0; j< i; j++){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max = 0;
        for(int i: dp){
            if(max < i){
                max = i;
            }
        }
        
        return max;
    }
    
    
}
