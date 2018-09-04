class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int globalMax = 0;
        int maxUntilNow = 0;
        for(int i = 1; i < prices.length; i++){
            int diff = prices[i] - prices[i-1];
            maxUntilNow = Math.max(0, maxUntilNow+diff);
            globalMax = Math.max(globalMax, maxUntilNow);
        }
        
        return globalMax;
    }
}