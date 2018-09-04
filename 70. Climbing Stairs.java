class Solution {
    public int climbStairs(int n) {
        int first = 1;
        int second = 1;
        int res = 1;
        for(int i = 2; i <= n; i++){
            res = first + second; dp[n] = dp[n-1]+dp[n-2]
            first = second; //next round dp[n-2] is currently dp[n-1]
            second = res;
        }
        
        return res;
    }
}