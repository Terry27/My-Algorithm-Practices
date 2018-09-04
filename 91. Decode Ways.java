class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] dp = new int[s.length()+1];
        //0 alone is invalid
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0: 1; //care input!!!
        
        for(int i = 2; i <= s.length();i++){
            int first = s.charAt(i-1)-'0';
            if(first > 0){
                dp[i] += dp[i-1];
            }
            int second = Integer.parseInt(s.substring(i-2,i));
            if(second >= 10 && second <= 26){
                dp[i] += dp[i-2];
            }
            
        }
        return dp[s.length()];
    }
}
