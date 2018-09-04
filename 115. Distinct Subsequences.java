class Solution {
    public int numDistinct(String s, String t) {
        // t rows
        // s columns
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < dp[0].length; i++){
            dp[0][i] = 1; // "" can be matched by any string
        }
        for(int i = 1; i <= t.length(); i++){
            for(int j = 1; j <= s.length(); j++){
                dp[i][j] = dp[i][j-1] +  (s.charAt(j-1) == t.charAt(i-1) ? dp[i-1][j-1]: 0); //care offset of s,t
            }
        }
        return dp[m][n];
    }
}